package com.henryxi.designpattern.behavioral.state;

public abstract class OrderState {
    protected final String CREATE_OPERATION = "create";
    protected final String PAY_OPERATION = "pay";
    protected final String CLOSE_OPERATION = "close";
    protected final String SEND_OPERATION = "send";
    protected final String RECEIVE_OPERATION = "receive";
    protected final String EVALUATE_OPERATION = "evaluate";
    protected String orderId;

    protected OrderState illegalOperate(String operation) {
        System.out.println("can't " + operation + " on " + this.getClass().getSimpleName() + ",order id" + orderId);
        return this;
    }

    abstract OrderState onCreating();

    abstract OrderState onPaying();

    abstract OrderState onClosing();

    abstract OrderState onSending();

    abstract OrderState onReceiving();

    abstract OrderState onEvaluating();
}
