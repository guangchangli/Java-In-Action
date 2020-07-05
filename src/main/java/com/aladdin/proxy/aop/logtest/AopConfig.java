package com.aladdin.proxy.aop.logtest;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lgc
 */
@Configuration
public class AopConfig {

    @Bean
    TimeLoggingAop timeLog(){
        return new TimeLoggingAop();
    }
    @Bean
    public HelloWord helloWord(){
        return new HelloWord();
    }

    @Bean
    public ProxyFactoryBean helloProxy() throws ClassNotFoundException {
        HelloWord helloWord = helloWord();
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(helloWord);
        proxyFactoryBean.setProxyInterfaces(HelloIter.class.getInterfaces());
        proxyFactoryBean.setInterceptorNames("defaultPointcutAdvisor");
        return proxyFactoryBean;
    }
    @Bean
    public JdkRegexpMethodPointcut jdkRegexpMethodPointcut(){
        JdkRegexpMethodPointcut jdk = new JdkRegexpMethodPointcut();
        jdk.setPattern(".*sayHello");
        return jdk;
    }
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        DefaultPointcutAdvisor pointcut = new DefaultPointcutAdvisor();
        pointcut.setAdvice(timeLog());
        pointcut.setPointcut(jdkRegexpMethodPointcut());
        return pointcut;
    }
}
