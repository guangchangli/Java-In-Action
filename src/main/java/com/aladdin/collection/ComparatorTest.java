package com.aladdin.collection;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class ComparatorTest {

    @Test
    public void testCompare() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("a", new BigDecimal(12), 170));
        personList.add(new Person("b", new BigDecimal(24), 175, new Student(27)));
        personList.add(new Person("c", new BigDecimal(12), 177));
        personList.add(new Person("a", new BigDecimal(12), 177));
        personList.add(new Person("b", new BigDecimal(54), 174, new Student(19)));

        // naturalOrder
        System.out.println("naturalOrder : ");
        personList.sort(Comparator.naturalOrder());
        personList.forEach(System.out::println);

        // comparing 1.0
        Optional<Person> optional = personList.stream().max(Comparator.comparing(Person::getAge));
        System.out.println("comparing 1.0 : get max age " + optional.get().toString() + "\n");

        // comparing 2.1
        optional = personList.stream().max(Comparator.comparing(Person::getName, Comparator.reverseOrder()));
        System.out.println("comparing 2.1 : get min name " + optional.get().toString() + "\n");

        // comparing 2.2
        optional = personList.stream().max(Comparator.comparing(Person::getName, String::compareTo));
        System.out.println("comparing 2.2 : get max name " + optional.get().toString() + "\n");

        // comparing 2.3
        optional = personList.stream().max(Comparator.comparing(Person::getStudent, (o1, o2) -> new Student().compare(o1, o2)));
        System.out.println("comparing 2.3 : get max student.age " + optional.get().toString() + "\n");


        // thenComparing 1.0
        System.out.println("thenComparing 1.0 : ");
        personList.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getHeight));
        personList.forEach(System.out::println);


        // thenComparing 2.0
        System.out.println("thenComparing 2.0 : ");
        personList.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getHeight).thenComparing(Person::getName));
        personList.forEach(System.out::println);


        // 升序
        System.out.println("升序 : ");
        personList.sort(Comparator.comparingInt(Person::getHeight));
        personList.forEach(System.out::println);


        // 降序
        System.out.println("降序 : ");
        personList.sort(Comparator.comparingInt(Person::getHeight).reversed());
        personList.forEach(System.out::println);

        // nullsLast
        System.out.println("nullsLast : ");
        personList.sort(Comparator.nullsLast(Comparator.comparing(Person::getName)));
        personList.forEach(System.out::println);

        // nullsLast
        System.out.println("nullsLast : ");
        personList.sort(Comparator.nullsLast(Comparator.comparing(Person::getName)));
        personList.forEach(System.out::println);
    }

}

