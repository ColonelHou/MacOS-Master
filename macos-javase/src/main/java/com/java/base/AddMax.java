package com.java.base;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by colonelhou on 2019/4/24.
 */
public class AddMax {
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger();
        System.out.println(Integer.MAX_VALUE + " ====> " + (1 + Integer.MAX_VALUE));
   }
}
