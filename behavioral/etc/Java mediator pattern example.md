# Java mediator pattern example
If you want to reduce the relationship between a set of objects mediator pattern is a good choice . In mediator pattern 
objects don't know each others . All object to send the " event " to the mediator . Mediator knows every object and 
invoke the method of them if needed. In this page I will show you how "button" and "text" works in mediator pattern.

![mediator pattern](https://uploads.disquscdn.com/images/84c7c831ab62feeeb961050f27efa887b2d3f7971ada0934a19923af57d93038.png)

Mediator knows every object. It can send "event" to every object.
```java
public interface Mediator {
    public void send(String message, Colleague colleague);
}

public class ApplicationMediator implements Mediator {
    private ArrayList<Colleague> colleagues;

    public ApplicationMediator() {
        colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    public void send(String event, Colleague originator) {
        for (Colleague colleague : colleagues) {
            if (colleague != originator) {
                colleague.handleEvent(event);
            }
        }
    }
}
```
There are only two colleagues in our example: button and text. They can work together even don't know each other.
```java
public abstract class Colleague {
    private Mediator mediator;

    public Colleague(Mediator m) {
        mediator = m;
    }

    public void triggerEvent(String event) {
        mediator.send(event, this);
    }

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void handleEvent(String message);
}

public class ButtonColleague extends Colleague {
    public ButtonColleague(Mediator m) {
        super(m);
    }

    public void handleEvent(String message) {
        System.out.println("Button handle event: " + message);
    }
}

public class TextColleague extends Colleague {

    public TextColleague(Mediator m) {
        super(m);
    }

    public void handleEvent(String message) {
        System.out.println("Text handle event: " + message);
    }
}
```
The code of client is like following.
```java
public class Client {
    public static void main(String[] args) {
        ApplicationMediator mediator = new ApplicationMediator();

        TextColleague text = new TextColleague(mediator);
        ButtonColleague button = new ButtonColleague(mediator);

        mediator.addColleague(text);
        mediator.addColleague(button);

        text.triggerEvent("Input text");
        button.triggerEvent("Click");
    }
}
```
Button and Text don't know each other. They only handle the event which mediator sent. The one of the most important
of mediator pattern is loose coupling. You can add another object and without changing button and text.