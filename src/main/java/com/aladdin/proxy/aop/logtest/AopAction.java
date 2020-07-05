package com.aladdin.proxy.aop.logtest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lgc
 */
public class AopAction {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println("当前 ioc bean 信息【");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("                    " + beanDefinitionName);
        }
        System.out.println("                  】");
        HelloWord helloWord = (HelloWord) applicationContext.getBean("helloWord");
        helloWord.sayHello();
        HelloIter helloIter= (HelloIter) applicationContext.getBean("helloProxy");
        helloIter.sayHello();
    }
}
