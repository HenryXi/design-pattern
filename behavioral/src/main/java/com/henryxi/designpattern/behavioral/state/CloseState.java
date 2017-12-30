package com.henryxi.designpattern.behavioral.state;

public class CloseState extends OrderState {
    public CloseState(String orderId) {
        System.out.println("order finish, order id:" + orderId);
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
        return null;
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
        return illegalOperate(EVALUATE_OPERATION);
    }
}
