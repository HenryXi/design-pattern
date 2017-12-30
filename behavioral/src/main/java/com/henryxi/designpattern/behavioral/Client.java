package com.henryxi.designpattern.behavioral;

import com.henryxi.designpattern.behavioral.state.BookingState;
import com.henryxi.designpattern.behavioral.state.OrderState;

public class Client {
    public static void main(String[] args) {
        System.out.println("----create order without paying----");
        OrderState state = new BookingState("orderId1");
        state = state.onCreating();
        state.onClosing();
        System.out.println();
        System.out.println("----create order,pay and close the order----");
        OrderState state1 = new BookingState("order2");
        state1 = state1.onCreating();
        state1 = state1.onPaying();
        state1.onClosing();
        System.out.println();
        System.out.println("----create order, pay order, send goods, close order----");
        OrderState state2 = new BookingState("order3");
        state2 = state2.onCreating();
        state2 = state2.onPaying();
        state2 = state2.onSending();
        state2.onClosing();
        System.out.println();
        System.out.println("----create order, pay order, send goods, receive goods, evaluate----");
        OrderState state3 = new BookingState("order4");
        state3 = state3.onCreating();
        state3 = state3.onPaying();
        state3 = state3.onSending();
        state3 = state3.onReceiving();
        state3 = state3.onEvaluating();
        state3.onClosing();
    }
}
