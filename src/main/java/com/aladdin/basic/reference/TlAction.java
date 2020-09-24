package com.aladdin.basic.reference;

/**
 * @author gopher lee
 * @create 2020/9/17 16:42
 */
public class TlAction {
    static ThreadLocal<Integer> tl=new ThreadLocal<>();
    static {
        tl.set(-1);
    }
    public static void main(String[] args) {
        test();
    }
    static void test(){
        try {
            System.out.println("name1: "+Thread.currentThread().getName());
            System.out.println(2/0);
        }catch (Exception e){
            System.out.println("name2: "+Thread.currentThread().getName());
            if (tl.get()<0)
            System.out.println("-------");
        }
    }
}
