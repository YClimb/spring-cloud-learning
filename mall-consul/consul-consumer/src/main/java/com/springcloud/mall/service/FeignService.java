package com.springcloud.mall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * feign service
 *
 * @author yclimb
 * @date 2020/9/15
 */
@FeignClient(name = "consul-provider", contextId = "test", path = "/")
public interface FeignService {

    @GetMapping("/getInfo/{name}")
    String getInfo(@PathVariable(value = "name") String name);
}
