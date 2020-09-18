package com.springcloud.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * consul 服务提供者
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ConsulProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulProviderApplication.class, args);
    }

    @GetMapping("/getInfo/{name}")
    public String getInfo(@PathVariable(name = "name", value = "", required = false) String name) {
        return name + " say: hello world!";
    }
}
