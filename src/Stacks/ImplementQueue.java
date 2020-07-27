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

