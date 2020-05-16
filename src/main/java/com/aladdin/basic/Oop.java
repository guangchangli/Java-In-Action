package com.aladdin.basic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author lgc
 */
public class Oop {
    /**
     *  对象由的状态(实例域)和行为(方法)组成
     *  对象状态的改变必须通过调用方法实现
     *  封装关键在于不让类中方法直接访问其他类的实例域,隐藏内部实现细节，只需要关心通过方法可以得到什么
     *  程序仅通过对象的特定方法访问对象数据，提高重用性和可靠性
     *  意味着可以全面的改变存储数据，只要通过同样的方法操作数据，其他对象就不会介意所发生的改变
     */

    /**
     类之间的关系
     依赖 uses-a 一个类的方法操作另一个类的对象，这个类依赖另一个类 他需要关心另一个类实例的状态变化 耦合度比较高
     聚合 has-a  关联 类对象包含另一个对象
     继承 is-a
     对象变量不是对象 只是另一个对象的引用(初始化后)
     */

    /**
     * 更改器方法 和访问器方法
     * 是否改变状态
     * localDate 没有
     * Date.setTime 设置毫秒数
     */


    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        Calendar instance = GregorianCalendar.getInstance();
        //更改器方法
        instance.add(Calendar.YEAR,1);
        System.out.println(instance.get(Calendar.YEAR));

    }
}
