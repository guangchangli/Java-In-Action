package com.aladdin.spring.bean;

import com.aladdin.spring.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * person 构造方法执行
 * 1.postProcessBeforeInitialization 执行：class com.aladdin.spring.Person beanNames:person
 * 2.@PostStruct() 执行
 * 3.afterPropertiesSet 执行，properties 信息：postProcessBefore
 * 4.init-method 执行
 * 5.postProcessAfterInitialization 执行：class com.aladdin.spring.Person beanName :person
 * @author lgc
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor, InstantiationAwareBeanPostProcessor {

    /**
     * beanPostProcessor 实现
     * ioc 容器启动刷新容器方法最后创建单实例bean 容器没有bean 创建bean
     * doCreateBean方法
     * 之前缓存bean 处理循环依赖
     *  populateBean 方法里面 自动注入属性赋值 处理beanPostProcessor 子类方法
     *  initializeBean 初始化
     *      1.applyBeanPostProcessorsBeforeInitialization   初始化之前
     *      2.invokeInitMethods                             执行初始化
     *      3.applyBeanPostProcessorsAfterInitialization    初始化之后
     *  遍历所有beanPostProcessor 执行 beforeInitialization  返回null 结束循环
     *  beanPostProcessor应用
     *   bean 赋值
     *   注入组件
     *   生命周期注解
     *   @Async
     *   applicationContextAware
     *   AutowireAnnotationBeanProcessor
     */

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("1.postProcessBeforeInitialization 执行："+bean.getClass().toString()+" beanNames:"+beanName);
        if (bean instanceof Person) {
            Person person = (Person) bean;
            if (!person.getName().equals("李广昌")) {
                person.setName("postProcessBefore李广昌");
            }
            return person;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5.postProcessAfterInitialization 执行："+bean.getClass().toString()+" beanName :"+beanName);
        if (bean instanceof Person){
            Person person= (Person) bean;
            person.setName("postProcessAfter李广昌");
            return person;
        }
        return bean;
    }
}
