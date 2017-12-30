package com.henryxi.designpattern.behavioral.state;

public class SendingState extends OrderState {
    public SendingState(String orderId) {
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
        System.out.println("close order, waiting receive goods and return it then refund money.");
        return new CloseState(orderId);
    }

    @Override
    public OrderState onSending() {
        System.out.println("send goods to customer.");
        return new ReceivingState(orderId);
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
