package com.aladdin.proxy.aop.configaction.services;

import org.springframework.stereotype.Component;

/**
 * @author lgc
 */
@Component
public class IndexService {

    public void index(){
        System.out.println("public index");
    }
}
