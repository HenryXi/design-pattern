# Java prototype pattern example
Sometimes creating a new object is expensive, you need use "new" keyword and set properties. Prototype pattern is a 
good way to create the instance without "new" keyword. You can change the value of properties when needed after 
cloning object. Example code is like following.
```java
public abstract class Prototype implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}

public class ConcretePrototype1 extends Prototype {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "this is ConcretePrototype1, name:" + super.getName();
    }
}

public class ConcretePrototype2 extends Prototype {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "this is ConcretePrototype2, name:" + super.getName();
    }
}
```
The code of Client is like following. Firstly, I create two concrete prototype classes and put them into a map. 
Clone them when I need a new instance. After cloning I change the property (name) of the class.
```java
public class Client {
    private static Map<String, Prototype> prototypeMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        init();

        Prototype cloneType1 = getPrototype("prototype1");
        cloneType1.setName("clone type1");

        Prototype cloneType2 = getPrototype("prototype2");
        cloneType2.setName("clone type2");

        System.out.println("clone type1:" + cloneType1);
        System.out.println("clone type2:" + cloneType2);
    }

    private static void init() {
        Prototype prototype1 = new ConcretePrototype1();
        Prototype prototype2 = new ConcretePrototype2();
        prototypeMap.put("prototype1", prototype1);
        prototypeMap.put("prototype2", prototype2);
    }

    private static Prototype getPrototype(String prototypeName) throws Exception {
        Prototype prototype = prototypeMap.get(prototypeName);
        if (prototype != null) {
            return prototype.clone();
        }
        throw new Exception("Prototype not found");
    }
}
```

**Advantage**

* Eliminate the overhead of initializing an object ("new" keyword is expensive)
* Save time when create objects have mostly the same properties.