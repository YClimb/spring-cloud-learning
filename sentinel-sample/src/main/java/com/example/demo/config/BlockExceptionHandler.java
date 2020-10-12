package com.example.demo.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 哨兵流控规则异常处理器
 *
 * @author yclimb
 * @date 2020/10/12
 */
public interface BlockExceptionHandler {

    /**
     * 在此处处理限流异常，可以跳转到指定页面或返回指定的内容
     *
     * @param request req
     * @param response resp
     * @param e e
     * @throws Exception e
     */
    void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception;
}