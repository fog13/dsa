package Iterator;

import java.util.Iterator;
import java.util.List;

import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    Iterator<NestedInteger> iterator;
    Integer curr;
    Stack<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        iterator = nestedList.iterator();
        stack = new Stack<>();
        hasNext();
    }

    @Override
    public boolean hasNext() {
        if(curr != null) {
            return true;
        }
        if (stack.isEmpty()) {
            if(iterator.hasNext()) {
                NestedInteger next = iterator.next();
                if(next.isInteger()) {
                    curr = next.getInteger();
                    return true;
                }
                if(next.getList().isEmpty()) {
                    return hasNext();
                }
                stack.push(next.getList().iterator());
                return hasNext();
            }
            return false;
        }
        if (!stack.peek().hasNext()) {
            stack.pop();
            return hasNext();
        }
        NestedInteger next = stack.peek().next();
        if(next.isInteger()) {
            curr = next.getInteger();
            return true;
        }
        if(next.getList().isEmpty()) {
            return hasNext();
        }
        stack.push(next.getList().iterator());
        return hasNext();
    }

    @Override
    public Integer next() {
        hasNext();
        Integer res = curr;
        curr = null;
        return res;
    }
}


interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
