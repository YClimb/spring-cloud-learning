//package com.example.demo.producer;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 使用 MessageChannel 进行消息发送
// *
// * @author yclimb
// * @date 2020/10/13
// */
//@Service
//public class ProducerRunner implements CommandLineRunner {
//
//    /*@Value("${spring.cloud.stream.rocketmq.bindings.input2.consumer.tags}")
//    private String tags;*/
//
//    /**
//     * 获取name为output的binding
//     */
//    @Autowired
//    private MessageChannel output;
//
//    /**
//     * 发送 tags 为 tagStr 的消息
//     * @param args args
//     * @throws Exception e
//     */
//    @Override
//    public void run(String... args) throws Exception {
//        Map<String, Object> headers = new HashMap<>(1);
//        //headers.put(MessageConst.PROPERTY_TAGS, tags);
//        Message message = MessageBuilder.createMessage(args, new MessageHeaders(headers));
//        output.send(message);
//    }
//}