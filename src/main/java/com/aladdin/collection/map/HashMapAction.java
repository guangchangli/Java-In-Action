package com.aladdin.collection.map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * @author lgc
 */
public class HashMapAction {
    public static void main(String[] args) {
        Map<String, List<String>> synchronizedMap = Collections.synchronizedMap(Maps.newHashMap());
        Map<String, List<String>> map = new HashMap<>();
        List<String> list;

        list = map.get("list-1");
        if (list == null) {
            list = new LinkedList<>();
            map.put("list-1", list);
        }
        list.add("one");

        // 使用 computeIfAbsent 可以这样写
        /**
         * computeIfAbsent if absent compute Function
         * Function is not null k-link-result_of_function
         */
        list = map.computeIfAbsent("list-1", null);// NullPointException
        list = map.computeIfAbsent("list-1", k -> Lists.newArrayList());// NullPointException
        list.add("one");
        System.out.println(map);

        String k = "key";
        HashMap<String, Integer> m = new HashMap<String, Integer>() {
            private static final long serialVersionUID = -706248676757706899L;
            {
            put(k, 1);
        }};
        Integer newVal = 2;
        if(m.containsKey(k)) {
            m.put(k, m.get(k) + newVal);
        } else {
            m.put(k, newVal);
        }
    }
}
