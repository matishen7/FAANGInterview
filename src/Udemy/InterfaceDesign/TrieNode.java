package Udemy.InterfaceDesign;

import java.util.HashMap;

public class TrieNode {
    public boolean end;
    public HashMap<Character,TrieNode> next;

    public TrieNode() {
    }

    ;

    public TrieNode(char value) {
        this.end = false;
    }
}
