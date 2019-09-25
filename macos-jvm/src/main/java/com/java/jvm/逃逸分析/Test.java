package com.java.jvm.逃逸分析;

/**
 * -XX:+DoEscapeAnalysis开启逃逸分析（jdk1.8默认开启）
 * -XX:-DoEscapeAnalysis 关闭逃逸分析
 *
 * ===========jdk8默认开启逃逸分析
 * $ jmap -histo 81784 | head
 *
 *  num     #instances         #bytes  class name
 * ----------------------------------------------
 *    1:           715        2394968  [I
 *    2:        135648        2170368  com.java.jvm.逃逸分析.Test$Admin
 *    3:          2794        1727648  [B
 *    4:          7241        1004208  [C
 *    5:          5280         126720  java.lang.String
 *    6:           720          81952  java.lang.Class
 *    7:          1354          63480  [Ljava.lang.Object;
 *
 * ==============关闭逃逸分析
 *    $ jmap -histo 81858| head
 *
 *  num     #instances         #bytes  class name
 * ----------------------------------------------
 *    1:       1000000       16000000  com.java.jvm.逃逸分析.Test$Admin
 *    2:           736        2532096  [I
 *    3:          2794        1727696  [B
 *    4:          7241        1004472  [C
 *    5:          5280         126720  java.lang.String
 *    6:           720          81952  java.lang.Class
 *    7:          1354          63480  [Ljava.lang.Object;
 */
public class Test {
    static class Admin{
        public String name;
    }

    public static void testEscape(){
        Admin admin=new Admin();
    }

    public static void main(String[] args) {
        System.out.println("start");
        long begin=System.currentTimeMillis();
        for(long i=0;i<1000000;i++){
            testEscape();
        }
        long end=System.currentTimeMillis();
        System.out.println("time:"+(end-begin));
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
