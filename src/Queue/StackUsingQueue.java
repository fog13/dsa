package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
}
// Problem 225 Implement Stack using Queues

class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        for(int i=0; i< size; i++) {
            queue.add(queue.remove());
        }
    }
    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
