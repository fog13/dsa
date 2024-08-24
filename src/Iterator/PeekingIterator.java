package Iterator;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        cache();
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        cache();
        Integer res = next;
        next = null;
        cache();
        return res;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || next != null;
    }

    private void cache() {
        if(next == null && iterator.hasNext()) {
            next = iterator.next();
            return;
        }
    }

}