package com.aladdin.collection.map;

import java.util.HashMap;

/**
 * @Author gopher lee
 * @Date 2020/8/25 15:18
 */
public class HashMapTest {
    public static void main(String[] args) {
        /*
            q: hashMap resize 的时候 get 访问几个 tab
         */
        HashMap map = new HashMap<>();
        map.put("Aa","Aa");
        map.put("BB","BB");
        map.put("C#","C#");
        System.out.println(("Aa".hashCode()) ^ (1 >>> 16));
        System.out.println(("BB".hashCode()) ^ (1 >>> 16));
        System.out.println(("C#".hashCode()) ^ (1 >>> 16));
    }
}
