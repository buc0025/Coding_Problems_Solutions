package Stacks;
import java.util.*;

/*
https://leetcode.com/problems/design-a-stack-with-increment-operation/
Design a stack which supports the following operations.

Implement the CustomStack class:

CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack or do nothing if the stack reached the maxSize.
void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
int pop() Pops and returns the top of stack or -1 if the stack is empty.
void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack.
 */

public class CustomStack {
    final int maxSize;
    ArrayList<Integer> arr;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new ArrayList<>();
    }

    public void push(int x) {
       if (arr.size() < maxSize) {
            arr.add(x);
        }
    }

    public int pop() {
        if (arr.size() == 0) {
            return -1;
        }
        return arr.remove(arr.size()-1);
    }

    public void increment(int k, int val) {
        if (k > arr.size()) {
            for (int i = 0; i < arr.size(); i++) {
                arr.set(i, arr.get(i) + val);
            }
        } else {
            for (int i = 0; i < k; i++) {
                arr.set(i, arr.get(i) + val);
            }
        }
    }
}
