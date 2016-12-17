# Java builder pattern example
There are two kinds of builder pattern on the internet. Both of them separate the construction of a complex object 
from its representation. In this page I will show you how to use them.

**1. The first kind (in the book `Effective Java, 2nd Edition`)**

This kind of builder pattern is easy. Car and CarBuilder code are like following. 
```java
public class Car {
    private String name;
    private int height;
    private String color;
    private int wheelNum;

    static class CarBuilder {
        private String name;
        private int height;
        private String color;
        private int wheelNum;

        public CarBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CarBuilder withHeight(int height) {
            this.height = height;
            return this;
        }

        public CarBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder withWheelNum(int wheelNum) {
            this.wheelNum = wheelNum;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    private Car(CarBuilder carBuilder) {
        this.name = carBuilder.name;
        this.color = carBuilder.color;
        this.height = carBuilder.height;
        this.wheelNum = carBuilder.wheelNum;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", wheelNum=" + wheelNum +
                '}';
    }

    // getter and setter methods
}
```
The code of client is like following. To build a `Car` you need set the values into builder then invoke `build` method 
of the builder.
```java
public class Client {
    public static void main(String[] args) {
        Car car =  new Car.CarBuilder()
                .withName("Car")
                .withHeight(1)
                .withWheelNum(4)
                .withColor("Red").build();
        System.out.println(car);
    }
}
```

**2. The second kind (in wiki)**

![Builder pattern](https://uploads.disquscdn.com/images/dc57741c44500168f14d07a603a246bf5111c21c9e11dafdea6034828ec57a5d.png)

You need define a builder interface (CarBuilder) in this kind of Builder pattern. The concrete code of building 
a `Car` is in the `CarBuilderImpl`.  
```java
public class Car {
    private String name;
    private int height;
    private String color;
    private int wheelNum;

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", wheelNum=" + wheelNum +
                '}';
    }

    // getter and setter methods
}

public interface CarBuilder {
    void setName(String name);

    void setHeight(int height);

    void setColor(String color);

    void setWheelNum(int wheelNum);

    Car createCar();
}

public class CarBuilderImpl implements CarBuilder {
    Car car;

    public CarBuilderImpl() {
        this.car = new Car();
    }

    @Override
    public void setName(String name) {
        car.setName("Car");
    }

    @Override
    public void setHeight(int height) {
        car.setHeight(2);
    }

    @Override
    public void setColor(String color) {
        car.setColor("Red");
    }

    @Override
    public void setWheelNum(int wheelNum) {
        car.setWheelNum(4);
    }

    @Override
    public Car createCar() {
        return car;
    }
}
```
You need a director to decide use which builder to build a car. You can implement `CarBuilder` in different ways to build 
different kind of cars. The code of director is like following.
```java
public class CarBuildDirector {
    private CarBuilder builder;

    public CarBuildDirector(CarBuilder builder) {
        //you can pass different kind of builder to build different cars
        this.builder = builder;
    }

    public Car construct() {
        builder.setWheelNum(4);
        builder.setColor("Red");
        builder.setName("Car");
        builder.setHeight(1);
        return builder.createCar();
    }

    public static void main(String[] args) {
        CarBuilder builder = new CarBuilderImpl();
        CarBuildDirector carBuildDirector = new CarBuildDirector(builder);
        System.out.println(carBuildDirector.construct());
    }
}
```

**Summary**

Both of them are `Builder pattern`. Using first kind of builder pattern can **avoid multiple constructors**. The second
kind is **flexible and safe**. You have to implement every method in builder interface when add another kind of builder 
which make sure every properties be initialized. 