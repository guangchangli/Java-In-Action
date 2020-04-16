package com.aladdin.basic;

/**
 * @author lgc
 **/
public class Father {

    protected void doS(){
        System.out.println("father do");
        System.out.println(this.getClass());
        this.doS();
    }

    public static void main(String[] args) {
        Father father=new son();
        father.doS();
    }
}
class son extends Father{
    @Override
    public void doS(){
        System.out.println("son do");
        System.out.println(super.getClass().getSuperclass());
        super.doS();
    }

}
