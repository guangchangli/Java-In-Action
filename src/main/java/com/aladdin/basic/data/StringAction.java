package com.aladdin.basic.data;

/**
 * @author lgc
 */
public class StringAction {
    public static void main(String[] args) {
        String s1 = new String("Java");//堆上引用
        String s2 = s1.intern();//复制堆上引用到常量池
        String s3 = "Java";//常量池
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//false
        System.out.println(s2 == s3);//true


        String s4 = "abc";
        String s5 = "a";
        String s6 = "bc";
        String s7 = s5 + s6;//StringBuilder.append
        System.out.println(s4 == s7);//false


        String s8 = "abc";
        final String s9 = "a";
        final String s10="bc";
        System.out.println(s8==s9+s10);//true

        String s11=new String("a")+new String("b");//引用堆中，常量池中有 a b
        s11.intern();//查找常量池 复制堆引用到常量池
        String s12="ab";
        System.out.println(s11==s11.intern());//true
        System.out.println(s11==s12);//true
    }
}
