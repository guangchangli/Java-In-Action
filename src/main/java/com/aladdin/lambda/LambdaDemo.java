package com.aladdin.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda 思想
 * 1。函数是一等公民 和其他数据类型一样
 * 2。引用透明，不依赖外部变量或者状态 只依赖输入，同样的输入输出相同
 * 3。无副作用 保持独立 不修改外部变量的值 并发无影响
 * 底层实现 是匿名内部类
 * 但是不等价 上下文的区别
 * this 在匿名内部类中就是匿名内部类对象
 * this 在lambda 中是定义lambda的对象
 * 不能修改定义在作用域外的局部变量，lambda 内的局部变量隐式的 final ，保证不被后面修改
 * 不允许声明一下个与局部变量同名的变量
 * 不要执行有副作用的操作
 * 方法引用
 * 类名::静态方法名
 * 对象::实例方法名
 * 类名::实例方法名(相比于2,其表达含义更清楚,但是这种方式语义的理解有点绕)
 * 类名::new
 *
 * @author lgc
 **/
public class LambdaDemo {
    static Integer b = 0;
    private String name;
    static void test() {

    }
    void test1(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        int a = 0;
        Thread thread = new Thread(() -> {
            int j = a;
            b++;
            j++;
        });
        Student student1 = new Student("aa", 60);
        Student student2 = new Student("bb", 70);
        Student student3 = new Student("cc", 80);
        Student student4 = new Student("dd", 90);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);


        students.sort(Comparator.comparingInt(o -> o.age));

        students.sort(Comparator.comparingInt(o -> o.age));

        students.sort(LambdaDemo::compare1);

        students.sort(Student::compare2);
    }
    private static int compare1(Student o1, Student o2) {
        return o1.age - o2.age;
    }



}
class Student{
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int compare2(Student other) {
        return this.age - other.age;
    }
}
