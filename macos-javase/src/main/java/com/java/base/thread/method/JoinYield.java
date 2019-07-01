package com.java.base.thread.method;

public class JoinYield {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("abc");
        });
        // 让t执行完再继续主线程
        t.join(); // 无限制的等待下去
        t.join(1000); //
    }
}
