package io.seata.samples.sca.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Provider 控制器，可是自主通过外网请求，也可以通过 Customer Open Feign 方式调用
 *
 * @author yclimb
 * @date 2020/10/15
 */
@RestController
public class ProviderController {

    @GetMapping("/feign/echo")
    public String feignEcho(String name) {
        return "feignEcho() hi " + name;
    }
}
