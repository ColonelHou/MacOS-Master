package com.java.base.thread;

/**
 * Created by colonelhou on 2019/4/20.
 */
public class DLock implements Runnable{
    public int flag = 1;
    static Object o1 = new Object(), o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag=" + flag + "\t  " + Thread.holdsLock(this));
        if (flag == 1) {
            synchronized (o1) {
                System.out.println("--------->" + Thread.holdsLock(o1));
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        DLock td1 = new DLock();
        DLock td2 = new DLock();
        td1.flag = 1;
        td2.flag = 0;
        new Thread(td1).start();
        new Thread(td2).start();
        System.out.println(Thread.holdsLock(td1));
    }
}
