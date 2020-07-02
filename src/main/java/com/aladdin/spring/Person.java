package com.aladdin.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Objects;

/**
 * @author lgc
 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor
 * <br> extend BeanPostProcessor 前面处理</br>
 * 1.@Bean(init-method)
 * 2.@PostStruct 赋值之后 @PreDestory 销毁之前 @JSR250 标准
 * 3.implments
 * InitializingBean_afterPropertiesSet
 * DisposableBean_destroy
 * 4.implements beanPostProcessor｜InstiationAwareBeanPostProcessor(靠前)
 */
public class Person implements InitializingBean, DisposableBean, ApplicationContextAware, BeanPostProcessor {
    @Value("@value")
    private String name;
    private ApplicationContext applicationContext;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("person 构造方法执行");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person[" +
                "name='" + name + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public void destroy() {
        System.out.println("disposableBean destroy() 执行");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("3.afterPropertiesSet 执行，properties 信息：" + this.getName());
    }

    public void personInit() {
        System.out.println("4.init-method 执行");
    }

    public void personClose() {
        System.out.println("destroy-method 执行");
    }

    @PostConstruct
    public void postStructPerson() {
        System.out.println("2.@PostStruct() 执行");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy() 执行");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("---------------");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("================");
        return bean;
    }
}
