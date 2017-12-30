package com.henryxi.designpattern.behavioral.state;

public class PayingState extends OrderState {
    public PayingState(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public OrderState onCreating() {
        return illegalOperate("create");
    }

    @Override
    public OrderState onPaying() {
        System.out.println("pay order, order id:" + orderId);
        return new SendingState(orderId);
    }

    @Override
    public OrderState onClosing() {
        System.out.println("close order, refund money");
        return new CloseState(orderId);
    }

    @Override
    public OrderState onSending() {
        return illegalOperate("send");
    }

    @Override
    public OrderState onReceiving() {
        return illegalOperate("receive");
    }

    @Override
    public OrderState onEvaluating() {
        return illegalOperate("evaluate");
    }
}
