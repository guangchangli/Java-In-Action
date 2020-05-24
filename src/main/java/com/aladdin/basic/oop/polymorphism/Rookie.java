package com.aladdin.basic.oop.polymorphism;

import java.util.Objects;

/**
 * 多态动态绑定
 *      非 private static final 构造器 方法会存储在方法表
 *      子类覆盖方法 不能低于超类方法的可见性
 *  final 阻止继承
 *          类声明成final 方法自动成为final 不包括域
 *   即时编译器准确的知道类之间的继承关系，能够检测出类是否真正的存在覆盖给定的方法
 *   如果方法很简短、被频繁调用并且没有被真正的覆盖，会将方法进行内联处理
 *   eg 内联调用 obj.getField 替换为 obj.field
 *   强制类型转换
 *      继承层次准啊还
 *      超类转换成子类之前，instanceof 检查
 *   instanceof
 *      obj instanceof class
 *      obj 必须为引用类型或者空类型
 *     子类型检查
 *      数组
 *      接口
 *      类
 *   x.equals(y)
 *      自反性
 *      对称性
 *      传递性
 *      一致性
 *      任意非空x.equals(null) false
 * @author lgc
 */
public class Rookie extends Boss {
    private static String level = "ROOKIE";
    public String name = "";
    public static String salary = "10k";

    @Override
    public String getSalary() {
        return super.getSalary();
    }

    public static void main(String[] args) {
        Boss boss=new Rookie();
        Rookie rookie1 = new Rookie();
        Rookie rookie2 = new Rookie();
        Rookie rookie= (Rookie) boss;
        System.out.println(rookie.getSalary());
        System.out.println(boss.getSalary());
        System.out.println(Objects.equals(rookie2,rookie1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rookie rookie = (Rookie) o;
        return Objects.equals(name, rookie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
