package com.aladdin.basic.data;

import com.alibaba.fastjson.JSON;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author lgc
 */
public class FastJsonAction {
    public static void main(String[] args) {
        /**
         * 1.jsonField
         * ordinal 序列化排序
         * name 指定名字序列化
         * format
         * jsonDirect json 不转义
         * serialize false 不序列化
         */
        LocalDate of = LocalDate.of(2020, 4, 17);
        Date from = Date.from(of.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        DataEntity dataEntity = new DataEntity();
        dataEntity.setName("李广昌");
        dataEntity.setAge(23);
        dataEntity.setBirth(from);
        Object o = JSON.toJSON(dataEntity);
        dataEntity.setAddress(o.toString());
        System.out.println(JSON.toJSONString(dataEntity));
    }
}
