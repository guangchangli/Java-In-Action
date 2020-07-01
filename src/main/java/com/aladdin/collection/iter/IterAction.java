package com.aladdin.collection.iter;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.*;

/**
 * iterator ListIterator
 * todo
 *
 * @author lgc
 */
public class IterAction {
    public static void main(String[] args) {
        /**
         * object 都会当作字
         */
        ArrayList<Object> list = Lists.newArrayList();
        HashSet<Object> sets = Sets.newHashSet("1", 2);
        list.add(2);
        list.add("99999999999999999");
        System.out.println(sets);
        System.out.println(list);
        for (Object o : list) {
            Integer integer = (Integer) o;
            if (integer > 1)
                list.remove(o);
        }
        System.out.println(list);
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
        }
        ListIterator<Object> listIterator = list.listIterator();

        HashMap<String, Map<String, Integer>> map = new HashMap<>(512);
        HashMap<String, Integer> inner = Maps.newHashMap();
        inner.put("aa", 100);
        inner.put("bb", 200);
        map.put("a", inner);
        map.put("b", inner);
        String s = "华夏是对方身份_d[123]123bhhfsf.pdf";
        /*
        华夏是对方身份_d   华夏是对方身份_d[123]123bhhfsf.pdf
         */

    }
}
