package com.java.jihe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by colonelhou on 2019/4/19.
 */
public class ConcurrentModificationExcep {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(2);
        Iterator<Integer> iterator = lista.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                iterator.remove();
        }
        System.out.println(lista.toString());



        ArrayList<Integer> listb = new ArrayList<Integer>();
        listb.add(2);
        // 这个错误, 增强for循环反编译后使用的iterator来迭代，使用的modcount与期望modcount不一致 导致错误
        for (Integer i : listb) {
            if (i == 2) {
                listb.remove(i);
            }
        }
        System.out.println(lista.toString());
    }
}
