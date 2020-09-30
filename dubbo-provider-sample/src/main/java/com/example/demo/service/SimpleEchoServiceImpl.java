package com.example.demo.service;

import com.example.demo.EchoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * Dubbo 服务提供方
 *
 * @author yclimb
 * @date 2020/9/30
 */
@DubboService
public class SimpleEchoServiceImpl implements EchoService {

    @Override
    public String echo(String message) {
        return "[ECHO] " + message;
    }
}
