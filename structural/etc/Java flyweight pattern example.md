# Java flyweight pattern example
Flyweight pattern help you use as less memory as possible in your program. Let's say you want print a word (helloWorld) 
in your program. You can define 10 characters one by one (h, e, l, l, o, W, o, r, l, d). I think you certainly won't
do this. When you define a string in java JVM won't new it directly it will check if this string exists or not. If
this string is not defined then create a new one otherwise return the exist one. This is flyweight design pattern.

![Flyweight pattern](https://uploads.disquscdn.com/images/0f6039a5e9cc7bdcd53892e2e371eecb34b32b9ebdb1228137e5a4119a381fe2.png)

The sample code of our scenario is like following.
```java
public abstract class Character {
    abstract String getName();
}

public class ConcreteCharacter extends Character {
    private String name;

    public ConcreteCharacter(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
```
Define a factory to create concrete `Character` class. The first time, it must check if the character is present. If
the character is not exist then create new one.
```java
public class CharacterFactory {
    private Map<String, Character> flyweightMap = new ConcurrentHashMap<>();

    Character getCharacter(String name) {
        if (!flyweightMap.containsKey(name)) {
            flyweightMap.putIfAbsent(name, new ConcreteCharacter(name));
        }
        return flyweightMap.get(name);
    }

    List<Character> getAllCharacters() {
        return new ArrayList<>(flyweightMap.values());
    }
}
```
The client code is like following.
```java
public class Client {
    public static void main(String[] args) {
        List<Character> helloWorld = new ArrayList<>();
        CharacterFactory factory = new CharacterFactory();
        helloWorld.add(factory.getCharacter("h"));
        helloWorld.add(factory.getCharacter("e"));
        helloWorld.add(factory.getCharacter("l"));
        helloWorld.add(factory.getCharacter("l"));
        helloWorld.add(factory.getCharacter("o"));
        helloWorld.add(factory.getCharacter("W"));
        helloWorld.add(factory.getCharacter("o"));
        helloWorld.add(factory.getCharacter("r"));
        helloWorld.add(factory.getCharacter("l"));
        helloWorld.add(factory.getCharacter("d"));
        System.out.println(helloWorld);
        System.out.println("total characters: " + factory.getAllCharacters());
    }
}
```
The output is like following.
```
[h, e, l, l, o, W, o, r, l, d]
total characters: [r, d, e, W, h, l, o]
```
There are 10 characters in this word (helloWorld); we only create 7 characters after using flyweight pattern. Flyweight
pattern is similar with [lazy initialization pattern](http://www.henryxi.com/java-lazy-initialization-example). Flyweight 
pattern don't have to lazy initialization. You can also initialize all characters when program start. Change `CharacterFactory` 
like following.
```java
public class CharacterFactory {
    private Map<String, Character> flyweightMap = new ConcurrentHashMap<>();

    public CharacterFactory() {
        flyweightMap.put("h",new ConcreteCharacter("h"));
        flyweightMap.put("e",new ConcreteCharacter("e"));
        flyweightMap.put("l",new ConcreteCharacter("l"));
        flyweightMap.put("o",new ConcreteCharacter("o"));
        flyweightMap.put("W",new ConcreteCharacter("W"));
        flyweightMap.put("r",new ConcreteCharacter("r"));
        flyweightMap.put("d",new ConcreteCharacter("d"));
    }

    Character getCharacter(String name) {
        if (!flyweightMap.containsKey(name)) {
            flyweightMap.putIfAbsent(name, new ConcreteCharacter(name));
        }
        return flyweightMap.get(name);
    }

    List<Character> getAllCharacters() {
        return new ArrayList<>(flyweightMap.values());
    }
}
```