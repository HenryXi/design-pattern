# Java facade pattern example
Facade pattern is very easy to understand. Let's say you have to call different subclasses to implement a feature.
You can use a facade class to hide the detail of bottom layer. The sample code is like following.

![Facade pattern](https://uploads.disquscdn.com/images/13fbc6d42b5f4ac817d571b5eb63e38eb6590d4f659f92e372c605ba979f4420.png)

```java
public class SubClass1 {
    public void method1(){
        System.out.println("this is method1 from subClass1");
    }
}

public class SubClass2 {
    public void method2(){
        System.out.println("this is method2 from subClass2");
    }
}

public class SubClass3 {
    public void method3(){
        System.out.println("this is method3 from subClass3");
    }
}

public class Facade {
    public void mainMethod(){
        SubClass1 subClass1 = new SubClass1();
        SubClass2 subClass2 = new SubClass2();
        SubClass3 subClass3 = new SubClass3();
        subClass1.method1();
        subClass2.method2();
        subClass3.method3();
    }
}
```
Client doesn't need to know the detail of bottom layer
```java
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.mainMethod();
    }
}
```
