package com.java.base.oop;

/**
 * Created by colonelhou on 2019/5/6.
 */
public class StrInternTest {
    public static void main(String[] args) {
        /*String sa = new String("abc");
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3)); // true
        System.out.println(str5 == str3);      // false
        System.out.println(str5.intern() == str3); // true
        System.out.println(str5.intern() == str4); // false

        System.out.println("===================");*/
//        String s1 = new StringBuilder().append("String").append("Test").toString();
        String a = "abc";
        String s1 = new String("abc");
        System.out.println(s1.intern() == s1);

//        String s2 = new StringBuilder().append("ja").append("va").toString();
        String s2 = new String("def");
        System.out.println(s2.intern() == s2);
    }
}
