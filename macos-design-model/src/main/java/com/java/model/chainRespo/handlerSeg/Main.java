package com.java.model.chainRespo.handlerSeg;

/**
 * Created by colonelhou on 2019/5/3.
 */
public class Main {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        Handler handlerC = new ConcreteHandlerC();
        handlerA.setNext(handlerB);
        handlerB.setNext(handlerC);

        int[] requests = {2,5,14,22,18,27,20};
        for (int request : requests) {
            handlerA.handlerRequest(request);
        }

    }
}
