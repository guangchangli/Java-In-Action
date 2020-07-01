package com.aladdin.basic.data;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.lang.reflect.Type;

/**
 * fastjson 自定义序列化类
 * 类似 myabtis 什么器 鉴别器 a什么玩意 cation
 *
 * @author lgc
 */
public class ValueSerializer implements ObjectSerializer {
    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
                      int features) {
        System.out.println(fieldName);
        System.out.println(fieldName);
        System.out.println(object);
        String address = (String) object;
        String text = "注意了" + address;
        serializer.write(text);
    }
}
