package com.springcloud.mall.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 测试服务配置
 *
 * @author yclimb
 * @date 2020/9/15
 */
@ConfigurationProperties("test")
@RefreshScope
@Data
@Component
public class TestProperties {
    private String name = "zhangsan";
    private Integer age = 10;
}
