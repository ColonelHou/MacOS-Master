package com.java.base.thread.juc_Utils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService service = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        service.submit(() -> {
            try {
                String a = "银行流水A";
                String aa = exgr.exchange(a);
                System.out.println("线程A 中获取的值 " + aa);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                String b = "银行流水B......";
                String a = exgr.exchange(b);
                System.out.println("线程B中获取到的值 : " + a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
