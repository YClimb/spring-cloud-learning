package com.example.demo.consumer;

/**
 * 使用 @StreamListener 注解接收消息
 *
 * @author yclimb
 * @date 2020/10/13
 */
//@Service
public class ReceiveService {

    //@StreamListener("input")
    public void receiveInput(String receiveMsg) {
        System.out.println("input receive: " + receiveMsg);
    }

    /*@StreamListener("input1")
    public void receiveInput1(String receiveMsg) {
        System.out.println("input1 receive: " + receiveMsg);
    }

    @StreamListener("input2")
    public void receiveInput2(String receiveMsg) {
        System.out.println("input2 receive: " + receiveMsg);
    }*/

}