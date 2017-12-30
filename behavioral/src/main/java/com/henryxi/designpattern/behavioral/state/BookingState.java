package com.henryxi.designpattern.behavioral.state;

public class BookingState extends OrderState {
    public BookingState(String orderId) {
        this.orderId = orderId;
    }

    @Override
    OrderState onCreating() {
        System.out.println("create order, id:" + orderId);
        return new PayingState(orderId);
    }

    @Override
    OrderState onPaying() {
        return illegalOperate(PAY_OPERATION);
    }

    @Override
    OrderState onClosing() {
        System.out.println("onClosing order before paying. order Id:" + orderId);
        return new CloseState(orderId);
    }

    @Override
    OrderState onSending() {
        return illegalOperate(SEND_OPERATION);
    }

    @Override
    OrderState onReceiving() {
        return illegalOperate(RECEIVE_OPERATION);
    }

    @Override
    OrderState onEvaluating() {
        return illegalOperate(EVALUATE_OPERATION);
    }
}
