package com.aladdin.basic.oop.overload;

/**
 * overloading 重载 相同的名字 不同的参数 就产生了重载
 * 编译器进行 重载解析找不到适合的方法就编译错误
 * signature 方法签名包括 方法名和参数类型 返回类型不是签名一部分
 * 类没有提供 构造器 系统才会提供一个默认的构造器
 * 初始化
 *  1。默认无参数构造 基本类型 数值 0 bool false reference null
 *  2。声明域初始化，构造器
 *  3。静态初始化块
 * 构造器过程
 *  1。数据域初始化为默认值
 *  2。按照声明次序，依次执行所有域初始化语句和初始化块
 *  3。如果构造器第一行调用了第二个构造器，则执行第二个构造器主题
 *  4。执行构造器主体
 *  jdk6 之前可以没有main 方法 jdk7 之后会检查
 * @author lgc
 */
public class OverLoad {
    private String name="";
    private int id;
    private Integer ids;
    private Integer integer = getInteger();

    private static int getInteger(){return 1;
    }

    public static void main(String[] args) {
        OverLoad overLoad = new OverLoad();
        System.out.println(overLoad);
        //OverLoad{name='null', id=0, ids=null, integer=1}
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(()-> System.out.println("s")));
    }

    @Override
    public String toString() {
        return "OverLoad{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", ids=" + ids +
                ", integer=" + integer +
                '}';
    }


}
