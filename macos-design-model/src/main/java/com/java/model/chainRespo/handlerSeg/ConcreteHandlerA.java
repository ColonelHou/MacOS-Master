package com.java.model.chainRespo.handlerSeg;

/**
 * Created by colonelhou on 2019/5/3.
 */
public class ConcreteHandlerA extends Handler{
    @Override
    public void handlerRequest(int request) {
        if (request < 10) {
            System.out.println(this.getClass().getName() + " 请求 < 10 的请求");
        } else {
            next.handlerRequest(request);
        }
    }
}
