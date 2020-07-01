package com.aladdin.basic.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @创建用户: fxb
 * @创建时间: 2017年11月07日 10:00
 * @描述: myself test demo 
 */
public class MyTest {
    public static class A {
        @JSONField(serializeUsing = AValueSerializer.class)
        public int value;
        private String an;
    }

    public static class AValueSerializer implements ObjectSerializer {
        @Override
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
                          int features) throws IOException {
            Integer value = (Integer) object;
            String text = value + "元";
            serializer.write(text);
        }
    }

    public static void main(String[] args) {
        A obj = new A();
        obj.value = 100;
        obj.an="qwe";
        String json = JSON.toJSONString(obj);
        System.out.println(json);
    }
}