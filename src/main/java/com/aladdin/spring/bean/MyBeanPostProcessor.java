package com.aladdin.spring.bean;

import com.aladdin.spring.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author lgc
 */
public class MyBeanPostProcessor implements BeanPostProcessor, InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
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
        if (bean instanceof Person){
            Person person= (Person) bean;
            person.setName("postProcessAfter李广昌");
            return person;
        }
        return bean;
    }
}
