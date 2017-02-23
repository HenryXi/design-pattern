package com.henryxi.designpattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void delPerson(Person person) {
        persons.remove(person);
    }

    public void showInfo(Status status) {
        for (Person person : persons) {
            person.accept(status);
        }
    }
}
