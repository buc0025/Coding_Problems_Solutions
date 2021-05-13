package strings;
/*
https://leetcode.com/problems/make-the-string-great/
Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this
until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.
 */

public class MakeStringGreat {

    /*
    Problem is very similar to remove duplicate adjacent chars in string problem. I originally used a stack but had to use an
    additional loop to extract the chars. I optimized it by looking at the last char in the stringbuilder rather than using
    stack.peek(). The top solution uses a stack and uses Math.abs() == 32 as a way of comparing the 2 adjacent chars to see if
    one is uppercase and the other is lowercase
     */

    public String makeGood(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (stringBuilder.length() > 0) {
                if (curr - 32 == (int) stringBuilder.charAt(stringBuilder.length()-1) ||
                        curr + 32 == (int) stringBuilder.charAt(stringBuilder.length()-1)) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                } else {
                    stringBuilder.append(curr);
                }
            } else {
                stringBuilder.append(curr);
            }
        }

        return stringBuilder.toString();
    }

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!stack.isEmpty()) {
                if (curr - 32 == (int) stack.peek() || curr + 32 == (int) stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(curr);
                }
            } else {
                stack.push(curr);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (char letter : stack) {
            stringBuilder.append(letter);
        }

        return stringBuilder.toString();
    }
}
