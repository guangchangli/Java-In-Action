package com.aladdin.collection.iter;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

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
        list.add("1");
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
    }
}
