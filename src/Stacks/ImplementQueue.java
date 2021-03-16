package Stacks;
import java.util.*;

/*
https://leetcode.com/problems/implement-queue-using-stacks/
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
 */

public class ImplementQueue {

    // Solution uses only 1 stack
    public MyQueue() {
        stack1 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        List<Integer> list = new ArrayList<>();
        while (!stack1.isEmpty()) {
            list.add(stack1.pop());
        }

        stack1.push(x);

        for (int i = list.size() - 1; i >= 0; i--) {
            stack1.push(list.get(i));
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }

        int res = stack1.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return res;
    }

    /** Get the front element. */
    public int peek() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }

        int res = stack1.peek();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    Stack<Integer> s1;
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int top = s2.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return top;
    }

    /** Get the front element. */
    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int top = s2.peek();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return top;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    Stack<Integer> enqueue;
    Stack<Integer> dequeue;

    /** Initialize your data structure here. */
    public ImplementQueue() {
        enqueue = new Stack<>();
        dequeue = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (dequeue.isEmpty()) {
            dequeue.push(x);
            return;
        }
        while (!dequeue.isEmpty()) {
            enqueue.push(dequeue.pop());
        }
        dequeue.push(x);
        while (!enqueue.isEmpty()) {
            dequeue.push(enqueue.pop());
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return dequeue.pop();
    }

    /** Get the front element. */
    public int peek() {
        return dequeue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return dequeue.isEmpty();
    }
}

