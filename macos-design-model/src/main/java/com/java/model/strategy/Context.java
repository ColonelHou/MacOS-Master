package com.java.model.strategy;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class Context {
    IAlgo iAlgo;

    public Context(IAlgo iAlgo) {
        this.iAlgo = iAlgo;
    }

    public IAlgo getiAlgo() {
        return iAlgo;
    }

    public void setiAlgo(IAlgo iAlgo) {
        this.iAlgo = iAlgo;
    }

    public int execute(int a, int b) {
        return iAlgo.doOperation(a, b);
    }
}
