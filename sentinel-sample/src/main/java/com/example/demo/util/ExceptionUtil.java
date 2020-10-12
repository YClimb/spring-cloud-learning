package com.example.demo.util;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 异常处理工具类
 *
 * @author yclimb
 * @date 2020/10/12
 */
public final class ExceptionUtil {

    /**
     * 使用 @SentinelResource(blockHandlerClass) 时使用，返回值必须和方法返回值一致
     * @param ex ex
     */
    public static void handleException(BlockException ex) {
        System.out.println("Oops: " + ex.getClass().getCanonicalName());
    }
}
