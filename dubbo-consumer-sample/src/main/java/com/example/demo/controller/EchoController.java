package com.example.demo.controller;

import com.example.demo.EchoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Dubbo Spring Cloud 服务消费
 *
 * @author yclimb
 * @date 2020/9/30
 */
@RestController
public class EchoController {

    @DubboReference
    private EchoService echoService;

    @GetMapping("/echo")
    public String echo(String message) {
        return echoService.echo(message);
    }

}
