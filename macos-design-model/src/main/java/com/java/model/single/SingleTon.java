package com.java.model.single;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class SingleTon {
    private volatile static SingleTon instance = null;
    private SingleTon() {
    }

    public static SingleTon getSigleInstance() {
        if (null == instance) {
            synchronized (SingleTon.class) {
                if (null == instance) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;

//        return LazyClass.INSTANCE;
    }

    private static class LazyClass {
        private static final SingleTon INSTANCE = new SingleTon();
    }

}
