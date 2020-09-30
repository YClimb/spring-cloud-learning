package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * service controller
 *
 * @author yclimb
 * @date 2020/9/30
 */
@RestController
public class ServiceController {

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message) {
        // 增加打印日志，便于 consumer 调用查询
        System.out.println("[ECHO] : " + message);
        return "[ECHO] : " + message;
    }
}
