package com.aladdin.basic.exception;

/**
 *
 * @author lgc
 */
public class ExceptionAction {
    public static void main(String[] args) {
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            //输出异常信息
            System.out.println(e);
            System.out.println("---");
            //会输出调用过程
            e.printStackTrace();
        }
    }
}
