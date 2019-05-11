package com.java.base.oop;

/**
 * Created by colonelhou on 2019/4/24.
 */
public class Father {
    public Father() {
        System.out.println("Father构造函数");
    }
    static {
        System.out.println("Father 静态块");
    }

    {
        System.out.println("Father 普通块");
    }
}
