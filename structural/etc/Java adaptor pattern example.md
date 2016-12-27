# Java adapter pattern example
Let's say you have an interface named "NewInterface"; you have two classes which implement the interface. Client will
loop the list of `NewInterface`. The code of client is like following.
```java
public class Client {
    public static void main(String[] args) {
        List<NewInterface> newInterfaces = new ArrayList<>();
        newInterfaces.add(new NewInterfaceImplA());
        newInterfaces.add(new NewInterfaceImplB());
        handleNewInterface(newInterfaces);
    }

    private static void handleNewInterface(List<NewInterface> newInterfaceList){
        for (NewInterface impl : newInterfaceList) {
            impl.newMethod();
        }
    }
}
```
The interface and implementation are like following.
```java
public interface NewInterface {
    void newMethod();
}

public class NewInterfaceImplA implements NewInterface {

    @Override
    public void newMethod() {
        System.out.println("this is implementA of new method");
    }
}

public class NewInterfaceImplB implements NewInterface {

    @Override
    public void newMethod() {
        System.out.println("this is implementB of new method");
    }
}
```
Let's say now you want reuse `LagacyClass`; the code of it is like following.
```java
public class LegacyClass {
    public void originMethod(){
        System.out.println("this is original method");
    }
}
```
You can't pass the instance of `LegacyClass` into `handleNewInterface` method; because it is not an implementation of
`NewInterface`. In this case we can use "Adapter pattern". Create an Adapter which named `NewInterfaceAdapter`; the
code of it is like following.
```java
public class NewInterfaceAdapter implements NewInterface {

    private LegacyClass legacyClass = new LegacyClass();

    @Override
    public void newMethod() {
        legacyClass.originMethod();
    }
}
```

![Adapter pattern](https://uploads.disquscdn.com/images/25b6aec96325475881291aebbc1da086f60a4ced08e0832203d1f2bf6ee66ce0.png)

After creating `NewInterfaceAdapter` you can change the code of client like following.
```java
public class Client {
    public static void main(String[] args) {
        List<NewInterface> newInterfaces = new ArrayList<>();
        newInterfaces.add(new NewInterfaceImplA());
        newInterfaces.add(new NewInterfaceImplB());
        newInterfaces.add(new NewInterfaceAdapter());//new adapter and handle it as an implementation of NewInterface
        handleNewInterface(newInterfaces);
    }

    private static void handleNewInterface(List<NewInterface> newInterfaceList){
        for (NewInterface impl : newInterfaceList) {
            impl.newMethod();
        }
    }
}
```
The output is like following.
```
this is implementA of new method
this is implementB of new method
this is original method
```