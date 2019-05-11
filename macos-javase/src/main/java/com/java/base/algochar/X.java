package com.java.base.algochar;

/**
 * Created by colonelhou on 2019/5/2.
 */
public class X {
    public static void main(String[] args) {
        // 0111 1111  0 64 32 16 8421
        System.out.println(1 + 2 + 4 + 8 + 16 + 32 + 64);
        byte bb = 127;
        System.out.println(Integer.toBinaryString(-20));
        System.out.println(Integer.toBinaryString(-6));
        System.out.println(-20 >> 2);
        System.out.println(-20 >>> 2);
        System.out.println(20 >> 2);
        System.out.println(20 >>> 2);
        // 0111 1100
        System.out.println(4 + 8 + 16 + 32 + 64);

        System.out.println("++++++++++++++++++++");
        int a = 60; /* 60 = 0011 1100 */
        int b = 13; /* 13 = 0000 1101 */
        System.out.println("a =      " + Integer.toBinaryString(a));
        System.out.println("a =      00" + Integer.toBinaryString(b));
        System.out.println("--------------------------------");
        System.out.println("(a | b)  " + Integer.toBinaryString(a | b));
        System.out.println("(a ^ b)  " + Integer.toBinaryString(a ^ b));
        System.out.println("(a & b)  00" + Integer.toBinaryString(a & b));

        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println(Integer.toBinaryString(-6));
        //                                             0110 取反+1 (1001 => 1010)
        // (1111 1111)  (1111 1111) (1111 1111)  (1111 1010)
        // (0001 1111)  (1111 1111) (1111 1111)  (1111 1111)
        System.out.println(-6 >>> 3);
        String hex = "00011111111111111111111111111111";
        System.out.println(Integer.parseInt(hex, 2));

    }
}
