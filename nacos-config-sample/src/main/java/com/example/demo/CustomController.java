package com.example.demo;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * 自定义
 *
 * https://start.aliyun.com/article/sca7lesson/outconfig
 *
 * @author yclimb
 * @date 2020/9/30
 */
@RestController
@RefreshScope
@EnableConfigurationProperties(User.class)
public class CustomController {

    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private int userAge;

    /**
     * 5.2 使用 Nacos Config 实现 @ConfigurationPropertiesBean 属性动态刷新
     */
    @Autowired
    private User user;

    /**
     * 5.3 使用 Nacos Config 监听实现 Bean 属性动态刷新
     */
    @Autowired
    private NacosConfigManager nacosConfigManager;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            String dataId = "nacos-config-sample.properties";
            String group = "DEFAULT_GROUP";
            nacosConfigManager.getConfigService().addListener(dataId, group, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("[Listener] " + configInfo);
                    System.out.println("[Before User] " + user);

                    Properties properties = new Properties();
                    try {
                        properties.load(new StringReader(configInfo));
                        String name = properties.getProperty("user.name");
                        int age = Integer.parseInt(properties.getProperty("user.age"));
                        user.setName(name);
                        user.setAge(age);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("[After User] " + user);
                }
            });
        };
    }

    @PostConstruct
    public void init() {
        System.out.printf("[init] user name : %s , age : %d%n", userName, userAge);
    }

    @PreDestroy
    public void destroy() {
        System.out.printf("[destroy] user name : %s , age : %d%n", userName, userAge);
    }

    @RequestMapping("/user")
    public String user() {
        //return String.format("[HTTP] user name : %s , age : %d", userName, userAge);
        return "[HTTP] " + user;
    }

}
