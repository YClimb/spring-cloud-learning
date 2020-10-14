package io.seata.samples.sca.customer.controller;

import io.seata.samples.sca.common.dubbo.api.DubboEchoService;
import io.seata.samples.sca.customer.feign.ProviderFeignService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户端控制器
 *
 * @author yclimb
 * @date 2020/10/14
 */
@RestController
@RefreshScope // Nacos动态刷新配置
public class CustomerController {

    @DubboReference
    private DubboEchoService dubboEchoService;

    @Autowired
    private ProviderFeignService providerFeignService;

    @Value("${user.name:yclimb}")
    private String name;

    @Value("${user.age:18}")
    private Integer age;

    /**
     * Dubbo 方式调用
     * @param name name
     * @return String
     */
    @GetMapping("/dubbo/echo/{name}")
    public String dubboEcho(@PathVariable("name") String name) {
        return dubboEchoService.echo(name);
    }

    /**
     * Open Feign 方式调用
     * @param name name
     * @return String
     */
    @GetMapping("/feign/echo")
    public String feignEcho(String name) {
        return providerFeignService.feignEcho(name);
    }

    /**
     * Nacos 动态获取配置
     * Nacos 控制台新建配置
     * dataid : common.yaml 并添加属性 user.name user.age
     * @return String
     */
    @GetMapping("/dynamicConfig")
    public String dubboEcho() {
        return dubboEchoService.echo(String.format("my name is %s, age is %d", name, age));
    }
}
