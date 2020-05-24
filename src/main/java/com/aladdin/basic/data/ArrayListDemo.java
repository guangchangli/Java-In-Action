package com.aladdin.basic.data;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author lgc
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<Object> list = Lists.newArrayList();
        list.ensureCapacity(10);
        //gc useless memory
        list.trimToSize();
    }
}
