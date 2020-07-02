package com.aladdin.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lgc
 */
@Configuration
@ComponentScan(basePackages = {"com.aladdin.spring"})
public class BeanInitConfig {

    @Bean(initMethod = "personInit",destroyMethod = "personClose")
    public Person person() {
        Person person = new Person();
        person.setName("per");
        return person;
    }
}
