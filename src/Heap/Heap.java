package Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {

    boolean isMin;
    List<T> heap;

    Heap(boolean isMin) {
        this.isMin = isMin;
        heap = new ArrayList<>();
    }

    public void add(T valueToBeAdded) {
        heap.add(valueToBeAdded);
        int idx = heap.size() - 1;
        while (idx > 0) {
            int parentIdx = (idx - 1) / 2;
            if (compare(parentIdx, idx)) {
                return;
            }
            // check if collection util method works
            swap(parentIdx, idx);
            idx = parentIdx;
        }
    }

    public T peek() {
        return heap.get(0);
    }

    public T poll() {
        T topValue = peek();
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        int idx = 0;
        while (idx * 2 + 1 < heap.size()) {

            int candidateIdx = idx * 2 + 1;
            if (idx * 2 + 2 < heap.size()) {
                if (compare(idx * 2 + 2, idx * 2 + 1)) {
                    candidateIdx = idx * 2 + 2;
                }
            }
            if (compare(idx, candidateIdx)) {
                break;
            }
            swap(idx, candidateIdx);
            idx = candidateIdx;
        }
        return topValue;
    }

    private boolean compare(int idxFirst, int idxSecond) {
        return (heap.get(idxFirst).compareTo(heap.get(idxSecond)) <= 0) == isMin;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void swap(int first, int second) {
        T el = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, el);
    }
}
