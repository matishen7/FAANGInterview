package Udemy.InterfaceDesign;

import Udemy.ReverseLinkedList;

public class MonarchProgram {
    public static void main(String[] args) {
        Monarchy mon = new Monarchy("Jake");
        System.out.println(mon.getOrderOfSuccession());

        mon.birth("Catherine", "Jake");
        mon.birth("Tom", "Jake");
        mon.birth("Celine", "Jake");
        mon.birth("Peter", "Celine");
        mon.birth("Jane", "Catherine");
        mon.birth("Farah", "Jane");
        mon.birth("Mark", "Catherine");
        System.out.println(mon.getOrderOfSuccession());

        mon.death("Jake");
        mon.death("Jane");
        System.out.println(mon.getOrderOfSuccession());
    }
}
