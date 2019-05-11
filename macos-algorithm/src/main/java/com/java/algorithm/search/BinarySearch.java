package com.java.algorithm.search;

/**
 * Created by colonelhou on 2019/4/15.
 * 因为二分查找每次排除掉一半的不适合值，所以对于n个元素的情况：
 * 一次二分剩下：n/2
 * 两次二分剩下：n/2/2 = n/4
 * 。。。
 * m次二分剩下：n/(2^m)
 * 在最坏情况下是在排除到只剩下最后一个值之后得到结果，所以为
 * n/(2^m)=1;
 * 2^m=n;
 * 所以时间复杂度为：log2(n)
 */
public class BinarySearch {
    public static int rank(int key,int[] a) {
        int low = 0;
        int high = a.length - 1;
        int index = -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }

    //测试用例
    public static void main(String[] args) {
        int[] a = {1,2,5,7,9,30,12,34,123};
        int i = rank(34,a);
        System.out.println(i);
        System.out.println(a[i]);
    }

}
