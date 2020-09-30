package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 指向服务提供者应用
 *
 * @author yclimb
 * @date 2020/9/30
 */
@FeignClient("nacos-discovery-provider-sample")
public interface EchoService {

    /**
     * echo(String) 方法在 Spring MVC 请求映射的方式与 nacos-discovery-provider-sample 中的 ServiceController 基本相同，
     * 唯一区别在于 @PathVariable 注解指定了 value 属性 “message”，
     * 这是因为默认情况，Java 编译器不会讲接口方法参数名添加到 Java 字节码中。
     *
     * @param message message
     * @return String
     */
    @GetMapping("/echo/{message}")
    String echo(@PathVariable("message") String message);
}
