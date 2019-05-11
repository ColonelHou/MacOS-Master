package com.java.base.thread.rePrint;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by colonelhou on 2019/5/1.
 */
public class X {
    private final static AtomicInteger atomI = new AtomicInteger();

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(127));
        System.out.println(14 % 11);
        System.out.println(5 % 11);
    }
}
