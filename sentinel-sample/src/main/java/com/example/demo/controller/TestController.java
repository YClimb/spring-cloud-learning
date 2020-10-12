package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制层
 *
 * @author yclimb
 * @date 2020/10/12
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public void test() {
        testService.test();
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        /*String str = testService.hello(111L);
        System.out.println(str);*/
        return testService.sayHello(name);
    }

    @GetMapping("/hello")
    public void hello() {
        testService.hello();
    }

}
