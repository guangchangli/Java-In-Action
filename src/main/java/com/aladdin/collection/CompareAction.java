package com.aladdin.collection;

import com.google.common.base.Ascii;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

/**
 * @author lgc
 */
public class CompareAction {
    public static void main(String[] args) {
        List<CompareA> list = Lists.newArrayList();
        list.add(new CompareA("a", 3));
        list.add(new CompareA("A", 1));
        list.add(new CompareA("c", 2));
        list.sort(new CompareA());
        //natualOrder 内置 comparable
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        System.out.println(list.stream().max(Comparator.comparing(CompareA::getAge)).orElseGet(CompareA::new));
        System.out.println(list.stream().max(Comparator.comparing(CompareA::getName, String.CASE_INSENSITIVE_ORDER)).orElseGet(null));
        System.out.println(list.stream().max(Comparator.comparing(CompareA::getName, String::compareToIgnoreCase)).orElseGet(null));
        System.out.println(list.stream().max(Comparator.comparing(CompareA::getName, Comparator.reverseOrder())).orElseGet(null));
        System.out.println(Ascii.isLowerCase('A'));
        System.out.println(Ascii.toUpperCase('a'));
        System.out.println(Ascii.SPACE);
        System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('A'));

        //thenCompare
        System.out.println("----thenCompare----");
        System.out.println(list.stream().sorted(Comparator.comparing(CompareA::getAge).thenComparing(CompareA::getName)));
        System.out.println();


    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    static class CompareA implements Comparator<CompareA>, Comparable<CompareA> {
        String name;
        Integer age;

        @Override
        public int compare(CompareA o1, CompareA o2) {
            return o1.age.compareTo(o2.age);
        }

        @Override
        public int compareTo(CompareA o) {
            return this.name.compareTo(o.name);
        }
    }

}
