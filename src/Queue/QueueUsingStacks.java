package Queue;


// 232. Implement Queue using Stacks

import java.util.Stack;

public class QueueUsingStacks {
}

class MyQueue {
    Stack<Integer> writeStack;
    Stack<Integer> readStack;

    public MyQueue() {
        writeStack = new Stack<>();
        readStack = new Stack<>();
    }

    public void push(int x) {
        writeStack.push(x);
    }

    public int pop() {
        flushToRead();
        return readStack.pop();
    }

    public int peek() {
        flushToRead();
        return readStack.peek();
    }

    public boolean empty() {
        return readStack.isEmpty() && writeStack.isEmpty();
    }

    private void flushToRead() {
        if (readStack.isEmpty()) {
            while (!writeStack.isEmpty()) {
                readStack.push(writeStack.pop());
            }
        }
    }
}
