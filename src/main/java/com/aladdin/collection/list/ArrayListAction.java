package com.aladdin.collection.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lgc
 */
public class ArrayListAction {
    public static void main(String[] args) {
        ArrayList<Object> list = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        ArrayList<Integer> listCommon = Lists.newArrayList(1,3);
        boolean b = list.retainAll(listCommon);
        System.out.println(b);
        System.out.println(list);
        System.out.println(listCommon);
        ArrayList<Integer> list1 = Lists.newArrayList();
        List t2=list1;
        List<Object> t3= Collections.singletonList(list1);
    }
}
