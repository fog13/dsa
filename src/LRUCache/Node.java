package LRUCache;

public class Node<T> {
    T key;
    Node<T> next;
    Node<T> prev;

    Node(T key) {
        this.key = key;
        next = null;
        prev = null;
    }
}
