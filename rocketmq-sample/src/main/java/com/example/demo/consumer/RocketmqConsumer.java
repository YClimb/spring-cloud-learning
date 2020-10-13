package com.example.demo.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 使用 RocketMQ 原生的 API 进行消息消费
 *
 * @author yclimb
 * @date 2020/10/13
 */
@Service
public class RocketmqConsumer {

    @Value("${spring.cloud.stream.rocketmq.binder.name-server}")
    private String namesrvAddr;

    @Value("${spring.cloud.stream.bindings.output.destination}")
    private String topic;

    @Value("${spring.cloud.stream.bindings.input.group}")
    private String group;

    /**
     * Consumer 端消费同步消息
     * @throws Exception e
     */
    public void run() throws Exception {
        // 实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(group);
        // 设置NameServer的地址
        consumer.setNamesrvAddr(namesrvAddr);
        // docker 报 com.alibaba.rocketmq.remoting.exception.RemotingConnectException: connect to <192.168.0.120:10909> failed
        // 需要加上以下一句话解决，或者在 docker 配置 IP1=本机IP
        consumer.setVipChannelEnabled(false);

        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
        consumer.subscribe(topic, "*");
        // 注册回调实现类来处理从broker拉取回来的消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                // 标记该消息已经被成功消费
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动消费者实例
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
