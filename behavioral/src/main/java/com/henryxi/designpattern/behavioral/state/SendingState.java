package com.henryxi.designpattern.behavioral.state;

public class SendingState extends OrderState {
    public SendingState(String orderId) {
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
        System.out.println("close order before sending, refund money. order id:" + orderId);
        return new CloseState(orderId);
    }

    @Override
    public OrderState onSending() {
        System.out.println("send goods to customer. order id:" + orderId);
        return new ReceivingState(orderId);
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
