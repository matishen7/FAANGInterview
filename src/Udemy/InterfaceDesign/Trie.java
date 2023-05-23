package Udemy.InterfaceDesign;

import java.util.ArrayList;
import java.util.List;

public class Trie implements ITrie {
    private List<TrieNode> children;

    public Trie() {
        children = new ArrayList<>();
    }

    @Override
    public void insert(String word) {
       /* TrieNode lettersSofar = null;
        for (int i = word.length() - 1; i >=0; i--) {
            TrieNode letters = new TrieNode(word.charAt(i), lettersSofar);
            lettersSofar = letters;
        }
        children.add(lettersSofar);*/
    }

    @Override
    public boolean search(String word) {
        return false;
    }

    @Override
    public boolean startsWith(String prefix) {
        return false;
    }
}
