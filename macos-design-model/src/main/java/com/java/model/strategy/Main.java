package com.java.model.strategy;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class Main {
    public static void main(String[] args) {
        IAlgo a = new AlgoAdd();
        IAlgo b = new AlgoMinus();
        IAlgo c = new AlgoMulti();

        Context context = new Context(a);
        System.out.println(context.execute(1, 2));

        context.setiAlgo(b);
        System.out.println(context.execute(1, 2));

        context.setiAlgo(c);
        System.out.println(context.execute(1, 2));
    }
}
