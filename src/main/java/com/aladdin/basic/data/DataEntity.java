package com.aladdin.basic.data;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author lgc
 */

public class DataEntity {
    @JSONField(name = "name",ordinal = 1)
    private String name;
    @JSONField(name = "AGE",ordinal = 2)
    private Integer age;
    @JSONField(name = "birthday",format = "yyyyMMdd",ordinal = 3)
    private Date birth;
    @JSONField(jsonDirect = true,ordinal = 4,serializeUsing = ValueSerializer.class)
    private String address;
//    @JSONField(serialize = false)

    @Override
    public String toString() {
        return "DataEntity[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ']';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
