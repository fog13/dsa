package Trie;


// Problem 208


import java.util.HashMap;
import java.util.Map;

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node.add(ch);
            node = node.get(ch);
            if (i == word.length() - 1) {
                node.setWord();
            }
        }
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.get(ch);
            if (node == null) {
                return false;
            }
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            node = node.get(ch);
            if (node == null) {
                return false;
            }
        }

        return true;
    }
}


class Node {
    Map<Character, Node> children;
    boolean isWord;

    Node() {
        children = new HashMap<>();
        isWord = false;
    }

    void setWord() {
        isWord = true;
    }

    void add(char ch) {
        if (children.get(ch) == null) {
            Node node = new Node();
            children.put(ch, node);
        }
    }

    Node get(char ch) {
        return children.getOrDefault(ch, null);
    }
}



















