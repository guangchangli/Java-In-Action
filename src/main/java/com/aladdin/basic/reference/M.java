package com.aladdin.basic.reference;

/**
 * @author lgc
 */
public class M {
    private String name;
    @Override
    protected void finalize() {
        System.out.println("finalize");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "M{" +
                "name='" + name + '\'' +
                '}';
    }
}
