package com.java.base.thread.pool.selfPool;

/**
 * Created by colonelhou on 2019/5/5.
 */
public class TheadBlockedQ {
    public static void main(String[] args) {
        ThreadExcutor excutor = new ThreadExcutor(3);
        for (int i = 0; i < 10; i++) {
            excutor.exec(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程 " + Thread.currentThread().getName() + " 在帮我干活");
                }
            });
        }
        excutor.shutdown();
    }
}
