package com.henryxi.designpattern.behavioral.state;

public class BookingState extends OrderState {
    public BookingState(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public OrderState onCreating() {
        System.out.println("create order, id:" + orderId);
        return new PayingState(orderId);
    }

    @Override
    public OrderState onPaying() {
        return illegalOperate(PAY_OPERATION);
    }

    @Override
    public OrderState onClosing() {
        System.out.println("close order before creating.");
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
