package com.example.demo.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 使用 RocketMQ 原生的 API 进行消息发送
 * https://github.com/apache/rocketmq/blob/master/docs/cn/RocketMQ_Example.md
 *
 * @author yclimb
 * @date 2020/10/13
 */
@Service
public class RocketmqProducer {

    @Value("${spring.cloud.stream.rocketmq.binder.name-server}")
    private String namesrvAddr;

    @Value("${spring.cloud.stream.bindings.output.destination}")
    private String topic;

    @Value("${spring.cloud.stream.bindings.input.group}")
    private String group;

    /**
     * Producer 端发送同步消息
     * @param message msg
     * @throws Exception e
     */
    public void run(String message) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer(group);
        // 设置NameServer的地址
        producer.setNamesrvAddr(namesrvAddr);
        // docker 报 com.alibaba.rocketmq.remoting.exception.RemotingConnectException: connect to <192.168.0.120:10909> failed
        // 需要加上以下一句话解决，或者在 docker 配置 IP1=本机IP
        producer.setVipChannelEnabled(false);
        // 启动Producer实例
        producer.start();

        // 创建消息，并指定Topic，Tag和消息体
        Message msg = new Message(topic, message.getBytes());
        // 发送并不要返回信息
        //producer.send(msg);
        // 发送消息到一个Broker
        SendResult sendResult = producer.send(msg);
        // 通过sendResult返回消息是否成功送达
        System.out.printf("%s%n", sendResult);

        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }

}
