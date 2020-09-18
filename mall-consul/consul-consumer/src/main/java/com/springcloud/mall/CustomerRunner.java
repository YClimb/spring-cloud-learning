package com.springcloud.mall;

import com.springcloud.mall.config.TestProperties;
import com.springcloud.mall.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 测试调用
 *
 * @author yclimb
 * @date 2020/9/15
 */
@Slf4j
@RestController
public class CustomerRunner implements ApplicationRunner {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private FeignService feignService;
    @Autowired
    private TestProperties testProperties;

    @Override
    public void run(ApplicationArguments args) {
        //showServiceInstances();
    }

    /**
     * 显示服务实例
     */
    private void showServiceInstances() {
        log.info("DiscoveryClient: {}", discoveryClient.getClass().getName());
        discoveryClient.getInstances("consul-provider").forEach(s -> {
            log.info("Host: {}, Port: {}", s.getHost(), s.getPort());
        });
    }

    /**
     * 使用 springcloud loadbalancer 访问
     */
    private void getInfo() {
        String lisa = restTemplate.getForObject("http://consul-provider/getInfo/{}", String.class, "lisa");
        log.info("getInfo: {}", lisa);
    }

    /**
     * 使用 openfeign 访问
     */
    private void getInfo2() {
        String lisa = feignService.getInfo("test lisa");
        log.info("getInfo2: {}", lisa);
    }

    @GetMapping("/test1")
    public void test1() {
        getInfo();
        getInfo2();
    }

    @GetMapping("/test2")
    public void test2() {
        log.info("testProperties:{}:{}", testProperties.getName(), testProperties.getAge());
    }
}
