# Java lazy initialization example
Lazy initialization pattern is similar to (lazy initialization singleton)[http://www.henryxi.com/java-singleton-pattern-example]. The key
point of lazy initialization is "no need no create". The sample of code is like following.
```java
public class Product {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final Map<String, Product> types = new HashMap<>();

    private Product(String name) {
        this.name = name;
    }

    public static Product getProductByName(String productName) {
        if (!types.containsKey(productName)) {// here is not thread-safe, I don't want to talk it in this blog
            types.put(productName, new Product(productName));
        }
        return types.get(productName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void showAllProduct() {
        System.out.println(types);
    }
}
```
The code of client is like following. Display all products after getting product.
```java
public class Client {
    public static void main(String[] args) {
        Product productA = Product.getProductByName("A");
        Product.showAllProduct();
        Product productB = Product.getProductByName("B");
        Product.showAllProduct();
    }
}
```
The output is like following.
```
{A=Product{name='A'}}
{A=Product{name='A'}, B=Product{name='B'}}
```