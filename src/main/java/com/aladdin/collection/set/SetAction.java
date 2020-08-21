package com.aladdin.collection.set;

import com.google.common.collect.Sets;

import java.util.HashSet;

/**
 * @author lgc
 */
public class SetAction {
    public static void main(String[] args) {
        HashSet<String> set = Sets.newHashSet();
        //add 比 contains 快吗？
        boolean s1 = set.add("s");
        boolean s = set.contains("s");
    }
}
