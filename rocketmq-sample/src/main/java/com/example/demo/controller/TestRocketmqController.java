package com.example.demo.controller;

import com.example.demo.consumer.RocketmqConsumer;
import com.example.demo.producer.RocketmqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制层
 *
 * @author yclimb
 * @date 2020/10/13
 */
@RestController
public class TestRocketmqController {

    /*@Autowired
    private ProducerRunner producerRunner;*/

    @Autowired
    private RocketmqProducer rocketmqProducer;

    @Autowired
    private RocketmqConsumer rocketmqConsumer;

    @GetMapping("/send/{msg}")
    public String sendMsg(@PathVariable String msg) {
        /*try {
            // 使用 MessageChannel 进行消息发送
            producerRunner.run(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            // 使用 RocketMQ 原生的 API 进行消息发送
            rocketmqProducer.run(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // 使用 RocketMQ 原生的 API 进行消息消费
            rocketmqConsumer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

}
