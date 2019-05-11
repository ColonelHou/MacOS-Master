package com.java.model.chainRespo.handlerSeg;

/**
 * Created by colonelhou on 2019/5/3.
 */
public class ConcreteHandlerC extends Handler{

    @Override
    public void handlerRequest(int request) {
        if (request >= 20) {
            System.out.println(this.getClass().getName() + " 处理 > 30 的请求");
        } else {
            next.handlerRequest(request);
        }
    }
}
