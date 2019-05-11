package com.java.algorithm.sort;

import java.util.Arrays;

/**
 * Created by colonelhou on 2019/4/14.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {2, 43, 54, 6, 7, 8, 90, 23, 43, 65, 345};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
        Object o = new Object();
    }

    public static void sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
//            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
//                    flag = false;
                }
            }

            /*if (flag) {
                break;
            }*/
        }
    }

}
