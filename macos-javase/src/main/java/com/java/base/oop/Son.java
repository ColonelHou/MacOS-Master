package com.java.base.oop;

/**
 * Created by colonelhou on 2019/4/24.
 */
public class Son extends Father{
    public Son() {
        System.out.println("Son构造");
    }

    static {
        System.out.println("子静态");
    }
    {
        System.out.println("子块");
    }
}
