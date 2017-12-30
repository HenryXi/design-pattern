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
        System.out.println("ILLEGAL OPERATION!! can't " + operation + " on " + this.getClass().getSimpleName() + ",order id:" + orderId);
        return this;
    }

    public abstract OrderState onCreating();

    public abstract OrderState onPaying();

    public abstract OrderState onClosing();

    public abstract OrderState onSending();

    public abstract OrderState onReceiving();

    public abstract OrderState onEvaluating();
}
