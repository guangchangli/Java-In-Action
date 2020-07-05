package com.aladdin.proxy.aop.configaction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面
 *
 * @author lgc
 */
@Aspect
@Component
public class NotVeryUseFulAspect {
    //point cut 切点 (连接点 joint point集合）
    @Pointcut(value = "execution(* com.aladdin.proxy.aop.configaction.services..*.*(..))")
    private void anyOldTransfer() {
    }

    //通知
    @Before("anyOldTransfer()")
    public void doAccessCheck() {
        System.out.println("before");
    }
}
