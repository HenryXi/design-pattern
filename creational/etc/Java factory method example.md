# Java factory method example
Factory method pattern is used to create different "product" when you overridden the `create` method in subclass.
Your business logic code is handle the "product" which created by overridden method. The diagram of it is like
following.

![Factory method](https://uploads.disquscdn.com/images/9a75a3c8cd62d02a4a971904c09db799643938e8158036bc2611d138a5b747c1.png)

**1. Factory**
```java
public abstract class Factory {
    public String showProductName() {
        // start your business logic code
        Product product = createProduct();
        return product.getProductName();
    }

    abstract Product createProduct();// override this method to create different product in subclass
}
public class ConcreteFactoryA extends Factory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
public class ConcreteFactoryB extends Factory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
```

**2. Product**
```java
public interface Product {
    String getProductName();
}
public class ProductA implements Product {
    @Override
    public String getProductName() {
        return "this is productA";
    }
}
public class ProductB implements Product {
    @Override
    public String getProductName() {
        return "this is productB";
    }
}
```
**3. Client**
```java
public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactoryA();
        //Factory factory = new ConcreteFactoryB();
        System.out.println(factory.showProductName());
    }
}
```

The key of factory method pattern is overriding the method which create "product". Subclass don't care about the business
logic, it's only responsible for creating different products. If you need another products just extend the `Factory`
class and override the `createProduct()` method.