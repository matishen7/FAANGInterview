package Udemy.InterfaceDesign;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
    List<Integer> set;

    public MyHashSet() {
        set = new ArrayList<>();
    }

    public void add(int key) {
        if (contains(key)) return;
        set.add(key);
    }

    public void remove(int key) {
        if (!contains(key)) return;
        for (int i = 0; i < set.size(); i++) {
            if (key == set.get(i)){
                set.remove(i);
                break;
            }
        }
    }

    public boolean contains(int key) {
        for (int i = 0; i < set.size(); i++)
            if (key == set.get(i)) return true;
        return false;
    }
}

class MyHashSetProgram{
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)
    }
}