package com.aladdin.proxy.aop.logtest;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * canonical
 *
 * @author lgc
 */
public class TimeLoggingAop implements MethodBeforeAdvice, AfterReturningAdvice{

    private long startTime = 0;

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object target) {
        long spentTime = System.nanoTime() - startTime;
        String canonicalName = target.getClass().getCanonicalName();
        String methodName = method.getName();
        System.out.println("执行 " + canonicalName + " # " + methodName + " 耗时 " + new BigDecimal(spentTime).divide(new BigDecimal(1000000)) + " 毫秒");
    }

    @Override
    public void before(Method method, Object[] objects, Object o) {
        startTime = System.nanoTime();
    }
}
