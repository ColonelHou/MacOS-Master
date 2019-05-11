package com.java.model.strategy;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class AlgoMinus implements IAlgo{
    @Override
    public int doOperation(int a, int b) {
        return a - b;
    }
}
