package Udemy.InterfaceDesign;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public String name;
    public boolean isAlive;
    public List<Person> children;

    public Person(String name) {
        this.name = name;
        this.isAlive = true;
        this.children = new ArrayList<>();
    }
}

