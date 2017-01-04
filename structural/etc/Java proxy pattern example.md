# Java proxy pattern example
You can use proxy pattern in your program, if you don't want use real object for some reason. For example, creating
a real object is expensive or real object is in the remote machine. The key of proxy pattern is proxy object and real object
implement the same interface and proxy object hold an instance of real object. 

![Proxy pattern](https://uploads.disquscdn.com/images/7c008040854df68a0d2ac106c3ddc8f43b5046711f9f7c9eed1cdb0e58c75f24.png)

The code is like following.
```java
public interface Calculator {
    int calculate(int a, int b);
}

public class RealObject implements Calculator {

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

public class Proxy implements Calculator {

    private RealObject realObject = null;

    public int calculate(int a, int b) {
        if (realObject == null) {//You can add your business logic here
            realObject = new RealObject();
        }
        return realObject.calculate(a, b);
    }
}
```
Client won't create real object directly.
```java
public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        System.out.println("result: " + proxy.calculate(1, 2));
    }
}
```