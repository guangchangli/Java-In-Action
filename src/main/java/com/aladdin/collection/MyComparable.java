package com.aladdin.collection;

/**
 * compareTo ascII
 * @author lgc
 */
public class MyComparable implements Comparable<MyComparable> {

    String name;

    @Override
    public int compareTo(MyComparable o) {
        return this.name.compareTo(o.name);
    }
}
