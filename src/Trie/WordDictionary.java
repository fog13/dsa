package Trie;

// Problem 211

public class WordDictionary {
    Trie trie;

    WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        Node node = trie.root;
        if (node == null) {
            return false;
        }
        return search(word, 0, node);
    }

    private boolean search(String word, int idx, Node node) {
        if (node == null) {
            return false;
        }
        if (idx == word.length()) {
            return node.isWord;
        }
        char candidate = word.charAt(idx);
        if (candidate == '.') {
            for (char ch : node.children.keySet()) {
                boolean res = search(word, idx + 1, node.get(ch));
                if (res) {
                    return true;
                }
            }
            return false;
        }

        return search(word, idx + 1, node.get(word.charAt(idx)));
    }
}

