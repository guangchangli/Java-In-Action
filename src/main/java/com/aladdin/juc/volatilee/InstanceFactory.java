package com.aladdin.juc.volatilee;

/**
 * class 被 jvm 加载 在线程使用之前会执行初始化
 * 在执行初始化期间, jvm 会获取一个锁 这个锁会同步多线程对同一个类的初始化
 * 即时发生了重排序 其他线程同步看不到
 *
 * 初始化一个类，包括执行这个类的静态初始化和初始化在这个类中声明的静态字段。
 * 根据Java语言规范，在首次发生下列任意一种情况时，一个类或接口类型T将被立即初始化。
 * 1)T是一个类，而且一个T类型的实例被创建。
 * 2)T是一个类，且T中声明的一个静态方法被调用。
 * 3)T中声明的一个静态字段被赋值。
 * 4)T中声明的一个静态字段被使用，而且这个字段不是一个常量字段。
 * 5)T是一个顶级类(Top Level Class，见Java语言规范的§7.6)，而且一个断言语句嵌套在T内部被执行。
 * Java语言规范规定
 * 对于每一个类或接口C，都有一个唯一的初始化锁LC与之对应。
 * 从C 到LC的映射，由JVM的具体实现去自由实现。
 * JVM在类初始化期间会获取这个初始化锁，并且每个线程至少获取一次锁来确保这个类已经被初始化过了
 * @author lgc
 */
public class InstanceFactory {
    private static class InstanceHolder{
        public static Instance instance = new Instance();
    }
    public static Instance getInstance(){
        return InstanceHolder.instance;
    }
    static class  Instance{

    }
}
