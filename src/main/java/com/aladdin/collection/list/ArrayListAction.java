package com.aladdin.collection.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lgc
 */
public class ArrayListAction implements Cloneable {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        ArrayList<Integer> listCommon = new ArrayList<>();
        listCommon.add(1);
        boolean b = list.retainAll(listCommon);
        System.out.println(b);
        System.out.println(list);
        System.out.println(listCommon);
        ArrayList<Integer> list1 = Lists.newArrayList();
        List t2=list1;
        List<Object> t3= Collections.singletonList(list1);
        ArrayListAction arrayListAction = new ArrayListAction();
        Object clone = arrayListAction.clone();
        ArrayList<Integer> clone1 = (ArrayList<Integer>) listCommon.clone();
        clone1.add(2);
        System.out.println("clone --");
        System.out.println(clone);
        System.out.println(arrayListAction);
        System.out.println(clone.equals(arrayListAction));
        System.out.println("clone1 --");
        System.out.println(listCommon.get(0));
        System.out.println(clone1.get(0));
        System.out.println(clone1.equals(listCommon));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (ArrayListAction)super.clone();
    }
}
