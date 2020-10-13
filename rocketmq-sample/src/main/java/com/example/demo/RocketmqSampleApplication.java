package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding({ Source.class, Sink.class })
@SpringBootApplication
public class RocketmqSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqSampleApplication.class, args);
    }

}
