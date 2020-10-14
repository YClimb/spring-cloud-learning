package io.seata.samples.sca.customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients // 扫描 @FeignClient 注解
@MapperScan("io.seata.samples.sca.customer.mapper")
public class CustomerApp {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class, args);
    }

}
