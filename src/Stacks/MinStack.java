package Stacks;
import java.util.*;

/*
https://leetcode.com/problems/min-stack/
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */

public class MinStack {
    Stack<Integer> fullStack;
    Stack<Integer> minStack;

    public MinStack() {
        fullStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        fullStack.push(x);
        if (!minStack.isEmpty() && minStack.peek() >= x) {
            minStack.push(x);
        }
        if (minStack.isEmpty()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (fullStack.peek().equals(minStack.peek())) {
            fullStack.pop();
            minStack.pop();
        } else {
            fullStack.pop();
        }
    }

    public int top() {
        return fullStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }



    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek() <= (minStack.peek()) {
            stack.pop();
            minStack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);

        if (minStack.isEmpty()) {

            minStack.push(x);
            return;
        }
        if (x <= minStack.peek()) {

            minStack.push(x);
        }
    }

    public void pop() {
        if (mainStack.peek().equals(minStack.peek())) {

            minStack.pop();
        }
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
