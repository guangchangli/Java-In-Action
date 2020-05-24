package com.aladdin.collection;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Comparator;

@Data
public class Person implements Comparable {
    private String name;
    private BigDecimal age;
    private Integer height;
    private Student student;

    public Person(String name, BigDecimal age, Integer height) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.student = new Student(0);
    }

    public Person(String name, BigDecimal age, Integer height, Student student) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.student = student;
    }

    @Override
    public int compareTo(Object o) {
        Person p1 = (Person) o;

        if (this.age.equals(p1.age)) {
            return p1.height - this.height;
        }
       return this.age.compareTo(p1.age);
    }
}

@Data
class Student implements Comparator {

    private int age;

    public Student() {
    }

    public Student(int age) {
        this.age = age;
    }

    @Override
    public int compare(Object o1, Object o2) {

        Student p1 = (Student) o1;
        Student p2 = (Student) o2;

        int result = Integer.compare(p1.age, p2.age);

        result = result == 0 ? ((p1.age > p2.age) ? 1 : -1) : result;

        return result;
    }
}

