package com.java.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by colonelhou on 2019/4/28.
 */
public class X {
    public static void main(String[] args) {
        int a [] = {2, 3, 4, 9, 12, 4, 6, 8};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int a[], int low, int high) {
        if (low < high) {
            int part = partition(a, low, high);
            sort(a, 0, part - 1);
            sort(a, part + 1, high);
        }
    }

    public static int partition(int a[], int low, int high) {
        int privot = low;
        int index = privot + 1;
        for (int i = index; i < high; i ++) {
            if (a[i] < a[privot]) {
                swap(a, i, index);
                index ++;
            }
        }
        swap(a, privot, index -1);
        return index - 1;
    }
    public static void swap(int a[], int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
