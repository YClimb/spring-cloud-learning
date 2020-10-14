package io.seata.samples.sca.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 *
 * @author yclimb
 * @date 2020/10/14
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("io.seata.samples.sca.provider.mapper")
public class ProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class, args);
    }
}
