package krivokapic.djordjije;

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
        this.stack.push(val);

        if(this.minStack.isEmpty()) {
            this.minStack.push(val);
            return;
        }

        int minVal = Math.min(val, this.minStack.peek());
        this.minStack.push(minVal);
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
