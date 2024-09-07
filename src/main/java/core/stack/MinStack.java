package core.stack;

import java.util.Stack;


// https://leetcode.com/problems/min-stack/description/
class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;


    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }


    public void push(int val) {
        if (this.stack.isEmpty()) {
            this.stack.push(val);
            this.minStack.push(val);

            return;
        }

        this.stack.push(val);
        int currentMin = this.minStack.peek();
        if (currentMin > val) {
            currentMin = val;
        }

        this.minStack.push(currentMin);
    }


    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }


    public int top() {
        return this.stack.peek();
    }


    public int getMin() {
        return this.minStack.peek();
    }
}