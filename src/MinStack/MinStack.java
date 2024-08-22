package MinStack;

import java.util.Stack;

public class MinStack {
    Stack<Node> stack;
    int min;

    MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
        }
        if (min > val) {
            min = val;
        }
        stack.push(new Node(val, min));
    }

    public void pop(int val) {
        stack.pop();
        if (!stack.isEmpty()) {
            min = stack.peek().min;
        }
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return min;
    }


}


class Node {
    int value;
    int min;

    Node(int value, int min) {
        this.value = value;
        this.min = min;
    }
}