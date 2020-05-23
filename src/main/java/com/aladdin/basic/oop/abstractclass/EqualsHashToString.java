package com.aladdin.basic.oop.abstractclass;

import java.util.Arrays;
import java.util.Objects;

/**
 * equals
 *  如果子类能够拥有自己相等的概念，对称性要求将强制采用 getClass 进行检测
 *  如果由超类决定相等的概念，就可以使用 instanceof 进行检测
 * hashCode
 *   不是唯一的
 *   hash 由对象导出 重新定义equals 必须重新定义hashcode方法 需要插入到散列表
 *   同时重写因为hashMap hashSet 需要进行比较解决冲突
 * @author lgc
 */
public class EqualsHashToString{
    private String name;
    public static void main(String[] args) {
        int[] arr1=new int[]{1,2};
        int[] arr2={1,1};
        boolean equals = Arrays.equals(arr1, arr2);
        System.out.println(equals);
        //
        EqualsHashToString equals1 = new EqualsHashToString("123");
        EqualsHashToString equals2 = new EqualsHashToString("123");
        System.out.println(equals1==equals2);
        System.out.println(equals1.equals(equals2));
        System.out.println(equals1);
        System.out.println(Arrays.toString(arr1));

    }

    public EqualsHashToString(String name) {
        this.name = name;
    }

    public EqualsHashToString() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsHashToString equals = (EqualsHashToString) o;
        return Objects.equals(name, equals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getClass().getName()+"{" +
                "name='" + name + '\'' +
                '}';
    }
}
