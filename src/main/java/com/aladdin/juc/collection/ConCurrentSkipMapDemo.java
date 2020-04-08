package com.aladdin.juc.collection;

import java.util.concurrent.ConcurrentSkipListSet;

/**适合排好序 空间换时间
 * 跳表 减少遍历
 * @author lgc
 **/
public class ConCurrentSkipMapDemo {
    public static void main(String[] args) {
        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();
        /**
         *  public ConcurrentSkipListSet() {
         *         m = new ConcurrentSkipListMap<E,Object>();
         *     }
         */
        skipListSet.add(1);
        skipListSet.add(2);
        skipListSet.add(3);
        skipListSet.add(4);
        skipListSet.add(5);
        Integer ceiling = skipListSet.ceiling(4);
        System.out.println(ceiling);

    }
}
