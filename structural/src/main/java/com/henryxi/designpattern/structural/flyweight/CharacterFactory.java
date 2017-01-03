package com.henryxi.designpattern.structural.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
