package com.henryxi.designpattern.behavioral.state;

public class PayingState extends OrderState {
    public PayingState(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public OrderState onCreating() {
        return illegalOperate(CREATE_OPERATION);
    }

    @Override
    public OrderState onPaying() {
        System.out.println("pay order, order id:" + orderId);
        return new SendingState(orderId);
    }

    @Override
    public OrderState onClosing() {
        System.out.println("close order before paying. order id:" + orderId);
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
        return illegalOperate(EVALUATE_OPERATION);
    }
}
