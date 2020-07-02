package com.aladdin.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lgc
 */
@Slf4j
public class BeanInitExpandAction {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext apc = new AnnotationConfigApplicationContext(BeanInitConfig.class);
        log.info("-----ioc 容器启动-----");
        String[] beanDefinitionNames = apc.getBeanDefinitionNames();
        System.out.println("当前 ioc bean 信息【");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("                   " + beanDefinitionName);
        }
        System.out.println("                  】");
        Person person = (Person) apc.getBean("person");
        System.out.println("person name is: " + person.getName());
        apc.close();
    }
}
