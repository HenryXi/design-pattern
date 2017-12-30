package com.henryxi.designpattern.behavioral.state;

public class EvaluatingState extends OrderState {
    public EvaluatingState(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public OrderState onCreating() {
        return illegalOperate(CREATE_OPERATION);
    }

    @Override
    public OrderState onPaying() {
        return illegalOperate(PAY_OPERATION);
    }

    @Override
    public OrderState onClosing() {
        System.out.println("close order:" + orderId + ",return goods refund money.");
        return new CloseState(orderId);
    }

    @Override
    public OrderState onSending() {
        return illegalOperate(SEND_OPERATION);
    }

    @Override
    public OrderState onReceiving() {
        return illegalOperate(RECEIVE_OPERATION);
    }

    @Override
    public OrderState onEvaluating() {
        System.out.println("evaluate goods.");
        return new CloseState(orderId);
    }
}
