package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * https://github.com/apache/rocketmq/tree/master/docs/cn
 * https://start.aliyun.com/article/sca7lesson/distributedmessaging
 * https://github.com/alibaba/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-examples/rocketmq-example/readme-zh.md
 *
 * @author yclimb
 * @date 2020/10/13
 */
//@EnableBinding({Source.class, Sink.class})
@SpringBootApplication
public class RocketmqSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqSampleApplication.class, args);
    }

    /*@Autowired
    Source source;
    @Bean
    public CommandLineRunner runner() {
        return (args) -> {
            //boolean success = source.output().send(MessageBuilder.withPayload("custom payload").setHeader("k1", "v1").build());  // ③
            String payload = "This is Payload";
            boolean success = source.output().send(MessageBuilder.withPayload(payload).build());
            System.out.println(success);
        };
    }
    @StreamListener(Sink.INPUT)
    @SendTo(Source.OUTPUT)
    public String receive(String msg) {
        System.out.println("receive:" + msg);
        return msg.toUpperCase();
    }*/

}
