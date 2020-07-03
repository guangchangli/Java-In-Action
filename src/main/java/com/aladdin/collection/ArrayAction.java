package com.aladdin.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * java.util.Arrays
 * 创建数组
 * 比较数组
 * 数组排序
 * 数组检索
 * 数组转流
 * 打印数组
 * 数组转list
 * setAll
 * parallelPrefix
 *
 * @author lgc
 */
public class ArrayAction {
    public static void main(String[] args) {
        /**
         * 1.创建数组&拷贝数据
         */
        String[] strings = {"a", "r", "r", "a", "y"};
        String[] newStrings = Arrays.copyOf(strings, 3);
        String[] strings1 = Arrays.copyOf(strings, 6);
        String[] strings2 = Arrays.copyOfRange(strings, 0, 2);
        String[] strings3 = new String[3];
        Arrays.fill(strings3, "fill");
        System.out.println(Arrays.toString(newStrings));
        System.out.println(Arrays.toString(strings1));
        System.out.println(Arrays.toString(strings2));
        System.out.println(Arrays.toString(strings3));
        /**
         * 2.比较数组 equals
         */
        System.out.println(Arrays.equals(strings, newStrings));
        /**
         * 3.排序
         */
        Arrays.sort(strings);
        /**
         * 4.检索 二分查找
         */
        int r = Arrays.binarySearch(strings, "r");
        int l = Arrays.binarySearch(strings, "r", String::compareToIgnoreCase);
        /**
         * 5.stream
         */
        System.out.println(Arrays.stream(strings).count());
        System.out.println(Arrays.stream(strings, 0, strings.length - 1).count());
        /**
         * 6. to list <java.util.Arrays.ArrayList>长度固定
         */
        List<String> strings4 = Arrays.asList(strings);
        ArrayList<String> strings5 = new ArrayList<>(Arrays.asList(strings));
        /**
         * 7.setAll
         */
        int[] ints = new int[10];
        Arrays.setAll(ints, i -> i * 10);
        System.out.println(Arrays.toString(ints));
        /**
         * 8.parallelPrefix
         */
        Arrays.parallelPrefix(ints, (a, b) -> a + b);
        System.out.println(Arrays.toString(ints));
    }
}
