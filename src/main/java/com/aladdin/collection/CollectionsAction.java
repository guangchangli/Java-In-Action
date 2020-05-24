package com.aladdin.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * comparator 和 comparable 同时存在 comparator-compare 生效
 * Collections(immutable)
 * 0.sort <=> list.sort
 * 1.singleton
 * 2.singletonList
 * 3.singletonMap
 * 4.emptyList
 * 5.emptyMap
 * 6.emptySet
 *
 * @author lgc
 */
public class CollectionsAction {


    public static void main(String[] args) {
        System.out.println("----list----");
        List<C> list = Lists.newArrayList();
        HashMap<Object, Object> map = Maps.newHashMap();
        list.add(new C("a", 3));
        list.add(new C("c", 2));
        list.add(new C("b", 1));
        System.out.println("singleton is :" + Collections.singleton(list));
        System.out.println("singletonList is :" + Collections.singletonList(list));
        Collections.sort(list);
        System.out.println("collections sort is :" + list);
        list.sort((o1, o2) -> o1.name.compareTo(o2.name));
        System.out.println("compareTo() is :" + list);
        list.sort(Comparator.comparing(o -> o.age));
        System.out.println("compare() :" + list);
        Comparator<C> reversed = new C().reversed();
        list.sort(reversed);
        System.out.println("comparator reversed is :" + list);
        list.add(new C("d", 4));
        C c = list.get(0);
        Comparator<C> comparing = Comparator.comparing(C::getName, String.CASE_INSENSITIVE_ORDER);
        Comparator<C> reversed1 = comparing.reversed();
        list.sort(reversed1);
        System.out.println(list);
        //随机排序 shuffle
        Collections.shuffle(list, new Random(2));
        //binarySearch
        System.out.println(list);
        int a = Collections.binarySearch(list, new C("c", 5));
        System.out.println(a);
        //max min
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        //indexOfSubList
        List<String> list1 = Arrays.asList("one two three four five six siven".split(" "));
        System.out.println(list1);
        List<String> subList = Arrays.asList("three four five six".split(" "));
        System.out.println(Collections.indexOfSubList(list1, subList));
        //lastIndexSubList
        System.out.println(Collections.lastIndexOfSubList(list1, subList));
        System.out.println("---lastIndexSubList");
        //replaceAll
        System.out.println(list1);
        System.out.println(Collections.replaceAll(list1, "six", "6"));
        System.out.println(list1);
        //rotate 移动
        Collections.rotate(list1, 2);
        System.out.println(list1);
        //copy 同位覆盖
        List m = Arrays.asList("one two three four five six siven".split(" "));
        System.out.println(m);
        List n = Arrays.asList("我 是 复制过来的".split(" "));
        System.out.println(n);
        Collections.copy(m, n);
        System.out.println(m);
        //swap
        Collections.swap(list1,1,2);
        System.out.println(list1);
        //fill
        Collections.fill(n,"xx");
        System.out.println(n);
        //nCopies
        List<String> strings = Collections.nCopies(5, "5");
        System.out.println(strings);


        System.out.println("----map----");
        System.out.println(Collections.singletonMap("key", "value"));
        System.out.println(Collections.emptyList());
        System.out.println(Collections.emptyMap());
        System.out.println(Collections.emptySet());
        //newSetFromMap 引用空的 keySet
        Map<Object, Boolean> objectObjectHashMap = Maps.newHashMap();
        Set<Object> objects = Collections.newSetFromMap(objectObjectHashMap);
        objectObjectHashMap.put("a", true);
        objectObjectHashMap.put("b", false);
        System.out.println(objects);
        // immutable
        Map<Object, Object> objectObjectMap = Collections.emptyMap();
        //java.lang.UnsupportedOperationException
        //objectObjectMap.put("a",1);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    static class C implements Comparable<C>, Comparator<C> {
        String name;
        int age;

        @Override
        public int compare(C o1, C o2) {
            return o1.name.compareTo(o2.name);
        }

        @Override
        public int compareTo(C o) {
            Integer age = this.age;
            return age.compareTo(o.age);
        }
    }
}

