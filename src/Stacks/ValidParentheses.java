package Stacks;
/*
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any
positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 */

public class ValidParentheses {
    public int minAddToMakeValid(String S) {
        Queue<Character> queue = new LinkedList<>();
        // Adding entire string to queue
        for (int i = 0; i < S.length(); i++) {
            queue.add(S.charAt(i));
        }

        int count = 0;

        // Counting how many open parentheses need a closing and vice versa
        while (!queue.isEmpty()) {
            char front = queue.poll();
            if (front == '(') {
                if (queue.peek() == null) {
                    count++;
                }
                if (queue.peek() != null && queue.peek() == '(') {
                    count++;
                }
                if (queue.peek() != null && queue.peek() == ')') {
                    queue.poll();
                }
            }
            if (front == ')') {
                count++;
            }
        }
        return count;
    }
}
