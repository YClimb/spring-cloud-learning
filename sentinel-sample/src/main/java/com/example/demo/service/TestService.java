package com.example.demo.service;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.example.demo.util.ExceptionUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试服务层(流控规则对应 Service 中的方法)
 *
 * @author yclimb
 * @date 2020/10/12
 */
@Service
public class TestService {

    /**
     * 自定义流控规则，手动代码实现
     */
    public void hello() {
        initFlowRules();

        // 循环30次
        int i = 30;
        while (i > 0) {
            // 1.5.0 版本开始可以直接利用 try-with-resources 特性，自动 exit entry
            try (Entry entry = SphU.entry("HelloWorld")) {
                // 被保护的逻辑
                System.out.println(i + ":hello world");
            } catch (BlockException ex) {
                // 处理被流控的逻辑
                System.out.println(i + "blocked!");
            }
            i--;
        }
    }

    /**
     * 初始化流控规则，用于 hello 自定义流控规则方法使用
     */
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    /**
     * 哨兵自定义异常类
     * 对应的 `handleException` 函数需要位于 `ExceptionUtil` 类中，并且必须为 static 函数.
     */
    @SentinelResource(value = "test", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public void test() {
        System.out.println("Test");
    }

    /**
     * 默认哨兵，触动规则无异常处理
     * @param name name
     * @return String
     */
    @SentinelResource(value = "sayHello")
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    /**
     * 原始函数
     * 需要借助于本类方法 exceptionHandler、helloFallback 来使用
     * @param s s
     * @return String
     */
    @SentinelResource(value = "hello", blockHandler = "exceptionHandler", fallback = "helloFallback")
    public String hello(long s) {
        return String.format("Hello at %d", s);
    }

    /**
     * Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
     * @param s s
     * @return String
     */
    public String helloFallback(long s) {
        return String.format("Halooooo %d", s);
    }

    /**
     * Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
     * @param s s
     * @param ex ex
     * @return String
     */
    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }
}
