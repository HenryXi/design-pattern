package com.henryxi.designpattern.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

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
