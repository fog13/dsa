package LRUCache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    int capacity;
    Map<Integer, CacheNode> lruCache;
    DoublyLinkedList<Integer> lruList;

    LRUCache(int capacity) {
        this.capacity = capacity;
        lruCache = new HashMap<Integer, CacheNode>();
        lruList = new DoublyLinkedList<Integer>();
    }

    public int get(int key) {
        if (!lruCache.containsKey(key)) {
            return -1;
        }
        CacheNode cacheNode = lruCache.get(key);
        lruList.moveToTop(cacheNode.lruCacheNode);
        return cacheNode.value;
    }

    public void put(int key, int value) {
        if(lruCache.containsKey(key)) {
            lruCache.get(key).value = value;
            lruList.moveToTop(lruCache.get(key).lruCacheNode);
            return;
        }

        if(lruCache.size() == capacity) {
            int deletedKey = lruList.popHead();
            lruCache.remove(deletedKey);
        }
        Node<Integer> nodeAddedToLru = lruList.add(key);
        CacheNode cacheNode = new CacheNode(value, nodeAddedToLru);
        lruCache.put(key, cacheNode);

    }

}

class CacheNode {
    int value;
    Node<Integer> lruCacheNode;

    CacheNode(int key, int value) {
        this.value = value;
        lruCacheNode = new Node<>(key);
    }
    CacheNode(int value, Node<Integer> node) {
        this.value = value;
        this.lruCacheNode = node;
    }
}
