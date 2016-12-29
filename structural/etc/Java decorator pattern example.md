# Java decorator pattern example
The aim of decorator pattern is adding new features without creating subclass. Subclass cannot add multiple features
flexibly and dynamically. Decorator pattern can solve these problems. Let's say you want make special pie with different
material.
 
![decorator](https://uploads.disquscdn.com/images/dd3d43041ec36bd7330235dd4421266ab65c74064a851770b761a246db376010.png)

The interface and simple implement are like following.
```java
public interface Pie {
    double getCost();

    String getIngredients();
}

public class SimplePie implements Pie {
    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "Pie";
    }
}
```
In order to make different kinds of pie we need an abstract class `PieDecorator` and multiple concrete decorators.
The codes of them are like following.
```java
public abstract class PieDecorator implements Pie {
    protected final Pie decoratedPie;

    public PieDecorator(Pie c) {
        this.decoratedPie = c;
    }

    public double getCost() {
        return decoratedPie.getCost();
    }

    public String getIngredients() {
        return decoratedPie.getIngredients();
    }
}

public class WithApple extends PieDecorator {
    public WithApple(Pie c) {
        super(c);
    }

    public double getCost() {
        return super.getCost() + 0.2;
    }

    public String getIngredients() {
        return super.getIngredients() + ", Apple";
    }
}

public class WithBlueberry extends PieDecorator {
    public WithBlueberry(Pie c) {
        super(c);
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }

    public String getIngredients() {
        return super.getIngredients() + ", Blueberry";
    }
}
```
Now you can make different kinds of pie with different ingredients.
```java
public class Client {
    public static void printInfo(Pie c) {
        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
    }

    public static void main(String[] args) {
        Pie c = new SimplePie();
        printInfo(c);

        c = new WithBlueberry(c);
        printInfo(c);

        c = new WithApple(c);
        printInfo(c);
    }
}
```
The output is like following.
```
Cost: 1.0; Ingredients: Pie
Cost: 1.5; Ingredients: Pie, Blueberry
Cost: 1.7; Ingredients: Pie, Blueberry, Apple
```