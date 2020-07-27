package Stacks;
import java.util.*;
/*
7/23/2020
https://leetcode.com/problems/implement-stack-using-queues/
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
 */
public class ImplementStack {
    Queue<Integer> stack;
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public ImplementStack() {

        stack = new LinkedList<>();
        queue = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.offer(x);
        } else {
            while (!stack.isEmpty()) {
                queue.offer(stack.poll());
            }
            stack.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (stack.isEmpty()) {
            while (!queue.isEmpty()) {
                stack.offer(queue.poll());
            }
            while (stack.size() > 1) {
                queue.offer(stack.poll());
            }
        }
        return stack.poll();
    }

    /** Get the top element. */
    public int top() {
        if (stack.isEmpty()) {
            while (!queue.isEmpty()) {
                stack.offer(queue.poll());
            }
            while (stack.size() > 1) {
                queue.offer(stack.poll());
            }
        }
        return stack.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty() && stack.isEmpty();
    }
}
