# spring-cloud-learning
Spring Cloud & Spring Cloud Alibaba Learning Project

## 项目结构
主体结构如下所示：
    
    - spring-cloud-learning
        - dubbo-consumer-sample
            - Dubbo Spring Cloud 服务消费方应用
        - dubbo-provider-sample
            - Dubbo Spring Cloud 服务提供方应用
        - dubbo-sample-api
            - Dubbo 服务接口
        - nacos-config-sample
            - 使用 Nacos Config 作为 Spring Cloud 分布式配置
            - 使用 Nacos Config 实现 Bean 动态刷新
        - nacos-discovery-provider-sample
            - 使用 Nacos Discovery 实现 Spring Cloud 服务注册和发现
        - nacos-discovery-consumer-sample
            - Nacos Discovery 整合 @LoadBalanced RestTemplate 以及 Open Feign 服务调用
        - rocketmq-sample
            - 使用 RocketMQ 整合 Spring Cloud Stream 完成消息的发送和接收
            - 使用 RocketMQ 原生方法完成消息的发送和接收
        - seata-sample
            - Spring Cloud Alibaba + Nacos + Dubbo + OpenFeign + Sentinel + Seata
            - sca-common 项目公用模块（实体类，Dubbo Api等）
            - sca-customer 消费者
            - sca-provider 服务提供者
        - sentinel-sample
            - 使用 Sentinel Starter 完成 Spring Cloud 应用的限流管理
        - xxx
            - xxx
        - .gitignore
        - README.md
        
## Spring Cloud Alibaba + Nacos + Dubbo + OpenFeign + Sentinel + Seata
> seata-sample 项目是一个汇总，里面包含大部分的应用，可以参考一下
> [seata-sample](https://github.com/YClimb/spring-cloud-learning/tree/master/seata-sample)

## 注意事项
> 本项目 server 使用 docker 来启动，朋友们可以参考 [docker-compose](https://github.com/YClimb/docker-compose) 项目，里面是具体的 docker 配置文件