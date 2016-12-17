# Java singleton pattern example
Singleton make sure only one instance in your program. There are two kinds of singleton: initialization first, lazy
initialization. The first one initializes class in the beginning. The second one initializes class when `getInstance`
method is first invoked. The codes of them are like following.

**1. Initialization first (general)**
```java
public class Singleton {
    private static Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }

    private Singleton() {
    }
}
```

**2. Lazy initialization**
```java
public class LazyInitSingleton {
    private static LazyInitSingleton lazyInitSingleton;

    private LazyInitSingleton() {
    }

    public static synchronized LazyInitSingleton getInstance() {
        if (lazyInitSingleton == null) {
            lazyInitSingleton = new LazyInitSingleton();
        }
        return lazyInitSingleton;
    }
}
```
Don't lose `synchronized` key word. Making `gentInstance` method synchronized make sure only one instance in your program
(thread safe) when multiple thread invoke `getInstance` method. To avoid the synchronization overhead I recommend you use first one.