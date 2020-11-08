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

class MyStack {
    Queue<Integer> front;
    Queue<Integer> end;

    public MyStack() {
        front = new LinkedList<>();
        end = new LinkedList<>();
    }

    // end queue should have no more than 1 element at all times
    public void push(int x) {
        if (end.isEmpty()) {
            end.add(x);
        } else {
            while (!end.isEmpty()) {
                int n = end.poll();
                front.add(n);
            }
            end.add(x);
        }
    }

    // Populate end queue with front queue's elements and offers them back to front
    // until there's 1 element left in end and returns that element
    public int pop() {
        if (end.isEmpty()) {
            while (!front.isEmpty()) {
                end.add(front.poll());
            }
            while (end.size() > 1) {
                front.add(end.poll());
            }
        }
        return end.poll();
    }

    // Same concept as pop but uses peek instead
    public int top() {
        if (end.isEmpty()) {
            while (!front.isEmpty()) {
                end.add(front.poll());
            }
            while (end.size() > 1) {
                front.add(end.poll());
            }
        }
        return end.peek();
    }

    public boolean empty() {
        return front.isEmpty() && end.isEmpty();
    }
}

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
