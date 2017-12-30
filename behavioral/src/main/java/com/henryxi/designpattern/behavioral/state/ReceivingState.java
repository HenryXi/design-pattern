package com.henryxi.designpattern.behavioral.state;

public class ReceivingState extends OrderState {
    public ReceivingState(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public OrderState onCreating() {
        return illegalOperate("create");
    }

    @Override
    public OrderState onPaying() {
        return illegalOperate("pay");
    }

    @Override
    public OrderState onClosing() {
        System.out.println("close order, return goods refund money.");
        return new CloseState(orderId);
    }

    @Override
    public OrderState onSending() {
        return illegalOperate("send");
    }

    @Override
    public OrderState onReceiving() {
        System.out.println("receive goods");
        return new EvaluatingState(orderId);
    }

    @Override
    public OrderState onEvaluating() {
        return illegalOperate("evaluate");
    }
}
