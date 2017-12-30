package com.henryxi.designpattern.behavioral.state;

public class ReceivingState extends OrderState {
    public ReceivingState(String orderId) {
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
        System.out.println("close order before receiving, take back goods refund money. order id:" + orderId);
        return new CloseState(orderId);
    }

    @Override
    public OrderState onSending() {
        return illegalOperate(SEND_OPERATION);
    }

    @Override
    public OrderState onReceiving() {
        System.out.println("receive goods, order id:" + orderId);
        return new EvaluatingState(orderId);
    }

    @Override
    public OrderState onEvaluating() {
        return illegalOperate(EVALUATE_OPERATION);
    }
}
