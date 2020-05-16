package com.aladdin.basic.oop;

/**
 * @author lgc
 */
public class Polymorphism {
    public static void main(String[] args) {
        Father son = new Son();
        son.test();
        Father father = new Father();
        father.test();
    }
}
