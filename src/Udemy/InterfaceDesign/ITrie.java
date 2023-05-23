package Udemy.InterfaceDesign;

public interface ITrie {
    void insert(String word);
    boolean search(String word);
    boolean startsWith(String prefix);
}
