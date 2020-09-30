package com.example.demo.service;

import com.alibaba.cloud.EchoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * model
 *
 * @author yclimb
 * @date 2020/9/30
 */
@Service
public class SimpleEchoServiceImpl implements EchoService {

    @Override
    public String echo(String message) {
        return "[ECHO] " + message;
    }
}
