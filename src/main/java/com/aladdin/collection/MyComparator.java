package com.aladdin.collection;

import java.util.Comparator;

/**
 * 域 需要作为比较参数 不能是基本类型，要用包装类型
 * @author lgc
 */
public class MyComparator implements Comparator<MyComparator> {

    String name;
    Integer age;

    @Override
    public int compare(MyComparator o1, MyComparator o2) {
        return o1.age.compareTo(o2.age);
    }

}
