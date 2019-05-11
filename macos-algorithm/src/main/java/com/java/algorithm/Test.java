package com.java.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by colonelhou on 2019/4/15.
 */
public class Test {
    static AtomicReference<Thread> cas = new AtomicReference<>();
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("t......");
            while (true){}
        });
        Thread tt = new Thread(() -> {
            System.out.println("tt......");
            while (true){}
        });
        t.start();
        tt.start();
        System.out.println(cas.compareAndSet(null, t));
        System.out.println(cas.compareAndSet(null, tt));
    }


}
