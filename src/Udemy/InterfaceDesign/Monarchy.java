package Udemy.InterfaceDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Monarchy implements IMonarchy {
    public Person king;
    public HashMap<String, Person> persons;

    public Monarchy(String king) {
        this.king = new Person(king);
        this.persons = new HashMap<>();
        persons.put(king, this.king);
    }

    @Override
    public void birth(String name, String parentName) {

        Person parent = this.persons.get(parentName);
        Person child = new Person(name);
        parent.children.add(child);
        this.persons.put(name, child);

    }

    @Override
    public void death(String name) {
        Person person = this.persons.get(name);
        if (person != null)
            person.isAlive = false;
    }

    @Override
    public List<String> getOrderOfSuccession() {

        List<String> order = new ArrayList<>();
        DFS(this.king, order);
        return order;
    }

    private void DFS(Person person, List<String> order)
    {
        if (person.isAlive) order.add(person.name);
        for (int i = 0; i < person.children.size();i++)
            DFS(person.children.get(i), order);
    }
}
