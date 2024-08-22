package LRUCache;

public class DoublyLinkedList<T> {
    int size;
    Node<T> head;
    Node<T> tail;

    DoublyLinkedList() {
        this.size = 0;
        head = null;
        tail = null;
    }

    Node<T> add(T key) {
        Node<T> nodeToBeAdded = new Node<T>(key);
        add(nodeToBeAdded);
        return nodeToBeAdded;
    }

    void add(Node<T> nodeToBeAdded) {
        size++;
        if (this.head == null) {
            this.head = nodeToBeAdded;
            this.tail = nodeToBeAdded;
            return;
        }

        tail.next = nodeToBeAdded;
        nodeToBeAdded.prev = tail;
        tail = nodeToBeAdded;
    }

    T delete(Node<T> node) {
        size--;
        T deletedKey = node.key;
        if( head == tail) {
            head = null;
            tail = null;
        }

        else if(head == node) {
            head.next.prev = null;
            head = node.next;
        }

        else if(tail == node) {
            tail.prev.next = null;
            tail = tail.prev;
        }

        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        return deletedKey;
    }

    T popHead() {
        return delete(head);
    }

    void moveToTop(Node<T> node) {
        delete(node);
        add(node);
    }
}