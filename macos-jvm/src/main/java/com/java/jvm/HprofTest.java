package com.java.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colonelhou on 2019/5/5.
 * -Xms10M -Xmx10M -Xmn2M -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/colonelhou/Documents/company/wksp/MacOS-JAVA/src/main/java/com/java/jvm/hprof -XX:+PrintGCDetails -Xloggc:/Users/colonelhou/Documents/company/wksp/MacOS-JAVA/src/main/java/com/java/jvm/hprof/gc.log
 */
public class HprofTest {
    private static final int _1MB= 1024 * 1024;  //约1m

    public static void main(String[] args) {
        /*byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[2 * _1MB];*/
//        test();
        /*List<String> list = new ArrayList<String>();;
        while (true) {
            list.add("aaaaaaaaaaaaaaaaaaaaaaa");
        }*/
//        permOOM();
        strOOM();
    }
    public static void strOOM() {
        String s = "aaaaaa";
        while (true) {
            s = s +"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        }
    }

    public static void permOOM() {
        Object[] array = new Object[10000000];
        for(int i=0; i<10000000; i++){
            String d = String.valueOf(i).intern();
            array[i]=d;
        }
    }

    public static void test() {
        test();
    }
}
