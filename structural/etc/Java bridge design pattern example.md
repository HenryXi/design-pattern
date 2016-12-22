# Java bridge design pattern example
Bridge pattern is useful for add a common property to a series of objects. Let's say we have a series of vehicles; 
like car and train. Different vehicles has different kind of wheels. It is easy to change wheels of vehicles after 
making wheel as a property of vehicles. 

![bridge design pattern](https://uploads.disquscdn.com/images/6daddbf876bdbcca112bc8353c3ddc849d9e2c74615929f39209c42dc050cb4c.png)

Sample code is like following.
```java
public abstract class Vehicle {
    protected Wheel wheel;

    public Vehicle(Wheel wheel) {
        this.wheel = wheel;
    }

    abstract void vehicleInfo();
}

public class Car extends Vehicle {

    public Car(Wheel wheel) {
        super(wheel);
    }

    @Override
    void vehicleInfo() {
        System.out.println("Car with " + wheel.wheelInfo());
    }
}
```
The relation code of Wheel
```java
public interface Wheel {
    String wheelInfo();
}

public class SmallWheel implements Wheel {

    @Override
    public String wheelInfo() {
        return "small wheel";
    }
}

public class BigWheel implements Wheel {

    @Override
    public String wheelInfo() {
       return "big wheel";
    }
}
```
The code of Client.
```java
public class Client {
    public static void main(String[] args) {
        Car bigCar = new Car(new BigWheel());
        bigCar.vehicleInfo();
        Car smallCar = new Car(new SmallWheel());
        smallCar.vehicleInfo();
    }
}
```
The output is like following.
```
Car with big wheel
Car with small wheel
```
We abstract wheel out as an interface. When there is a new kind of wheel we only need add a class (AGroupWheel). The
code of client is like following.
```java
public class Client {
    public static void main(String[] args) {
        Car bigCar = new Car(new BigWheel());
        bigCar.vehicleInfo();
        Car smallCar = new Car(new SmallWheel());
        smallCar.vehicleInfo();
        Car manyWheelCar = new Car(new AGroupWheel());
        manyWheelCar.vehicleInfo();
    }
}
```
The output is like following.
```
Car with big wheel
Car with small wheel
Car with a group of wheels
```

**Summary**

The relationship between `Wheel` and `Vehicle` is **Bridge**. Make the part of changing (Wheel) as interface and abstract
 this part as a property. We only need add a new class (AGroupWheel) when requirements change.