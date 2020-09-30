package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * https://start.aliyun.com/article/sca7lesson/servicediscovery
 *
 * @author yclimb
 * @date 2020/9/30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryProviderSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryProviderSampleApplication.class, args);
    }

}
