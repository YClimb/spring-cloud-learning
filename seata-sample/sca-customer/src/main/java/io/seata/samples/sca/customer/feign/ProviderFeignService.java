package io.seata.samples.sca.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Open Feign 方式调用 provider Controller 方法
 *
 * @author yclimb
 * @date 2020/10/15
 */
@FeignClient(value = "sca-provider")
public interface ProviderFeignService {

    /**
     * open feign 方式调用方法，调用路径：http://sca-provider/feign/echo?name=x
     * @param name name
     * @return String
     */
    @GetMapping("/feign/echo")
    String feignEcho(@RequestParam("name") String name);
}
