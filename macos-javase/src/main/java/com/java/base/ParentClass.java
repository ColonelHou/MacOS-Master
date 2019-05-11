package com.java.base;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class ParentClass {
    public String name = "parent";

    public static void main(String[] args) {
        ParentClass p = new SonClass();

        SonClass s = new SonClass();
        System.out.println(p.name + ", " + s.name);
        System.out.println("debug....");
    }
}
class SonClass extends ParentClass {
    public String name = "son";
}
