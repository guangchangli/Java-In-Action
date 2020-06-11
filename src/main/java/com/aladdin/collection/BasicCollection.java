package com.aladdin.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author lgc
 */
public class BasicCollection {
    public static void main(String[] args) {

    }

}

class ToArrayTest {

    /**
     * 自定义类型A，保存着id
     */
    static class A {
        int id;

        A(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return Integer.toString(id);
        }
    }

    public static void main(String[] args) {
        Collection<A> coll = new ArrayList<>();
        coll.add(new A(1));
        coll.add(new A(3));
        coll.add(new A(5));
        coll.add(new A(7));
        // 使用 new A[0] 来确定类型
        A[] as1 = coll.toArray(new A[0]);
        A[] as2 = new A[6];
        System.out.println(Arrays.toString(as2));
        Arrays.fill(as2, new A(999));
        System.out.println("as2"+Arrays.toString(as2));
        A[] as3 = coll.toArray(as2);

        System.out.println(Arrays.toString(as1));
        System.out.println(Arrays.toString(as2));
        System.out.println(Arrays.toString(as3));
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        String[] strings1 = strings.toArray(new String[4]);
        String[] strings2 = strings.toArray(new String[2]);
        System.out.println(Arrays.toString(strings1));
        System.out.println(Arrays.toString(strings2));
    }
}
