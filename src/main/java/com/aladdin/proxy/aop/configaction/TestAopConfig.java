package com.aladdin.proxy.aop.configaction;

import com.aladdin.proxy.aop.configaction.services.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lgc
 */
public class TestAopConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println("当前 ioc bean 信息【");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("                   " + beanDefinitionName);
        }
        System.out.println("                  】");
        IndexService indexService = (IndexService) applicationContext.getBean("indexService");
        indexService.index();
    }
}
