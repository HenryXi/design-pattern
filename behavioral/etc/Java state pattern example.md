# Java state pattern example
`State Pattern` is for the scenario which contains different states. Let's consider the state of Amazon orders.
When you want buy goods from Amazon the logic flow is: `create order -> pay -> send goods -> receive goods -> evaluate`.
The status of order is changed after every operation and the **action** of order is changed correspondingly. The
example code is like following.
```java
public abstract class OrderState {
    protected final String CREATE_OPERATION = "create";
    protected final String PAY_OPERATION = "pay";
    protected final String SEND_OPERATION = "send";
    protected final String RECEIVE_OPERATION = "receive";
    protected final String EVALUATE_OPERATION = "evaluate";
    protected String orderId;

    protected OrderState illegalOperate(String operation) {
        System.out.println("ILLEGAL OPERATION!! can't " + operation + " on " + this.getClass().getSimpleName() + ",order id:" + orderId);
        throw new RuntimeException("ILLEGAL OPERATION");
    }

    public abstract OrderState onCreating();

    public abstract OrderState onPaying();

    public abstract OrderState onClosing();

    public abstract OrderState onSending();

    public abstract OrderState onReceiving();

    public abstract OrderState onEvaluating();
}

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

public class EvaluatingState extends OrderState {
    public EvaluatingState(String orderId) {
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
        System.out.println("close order before evaluating, return goods refund money.");
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
        System.out.println("evaluate goods. order id:" + orderId);
        return new CloseState(orderId);
    }
}

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
//        state3 = state3.onReceiving();
        state3 = state3.onEvaluating();
        state3.onClosing();
    }
}
```

The output is like follwing.
```
----create order without paying----
create order, id:orderId1
close order before paying. order id:orderId1
order finish, order id:orderId1

----create order,pay and close the order----
create order, id:order2
pay order, order id:order2
close order before sending, refund money. order id:order2
order finish, order id:order2

----create order, pay order, send goods, close order----
create order, id:order3
pay order, order id:order3
send goods to customer. order id:order3
close order before receiving, take back goods refund money. order id:order3
order finish, order id:order3

----create order, pay order, send goods, receive goods, evaluate----
create order, id:order4
pay order, order id:order4
send goods to customer. order id:order4
ILLEGAL OPERATION!! can't evaluate on ReceivingState,order id:order4
Exception in thread "main" java.lang.RuntimeException: ILLEGAL OPERATION
```

**Summary**

`State Pattern` is very useful for reducing `if else` statement. If the action of object is related to its state
you can think about using this design pattern. After using it we can add new state without changing the main logic.

EOF