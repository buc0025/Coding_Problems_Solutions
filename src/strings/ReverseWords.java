package strings;
/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and
initial word order.
 */

public class ReverseWords {

    // Previous problem that was not committed
    public String reverseWords(String s) {
        StringBuilder reverse = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // Reverses words in string until last space
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (s.charAt(i) == ' ') {
                while (!stack.isEmpty()) {
                    reverse.append(stack.pop());
                }
            }
        }

        reverse.append(" ");

        // There should be one word left in stack
        while (!stack.isEmpty()) {
            reverse.append(stack.pop());
        }

        return reverse.toString().trim();
    }

    public String reverseWords(String s) {
        StringBuilder reverse = new StringBuilder();
        String[] word = s.split(" ");

        // Appending the reverse of the words in array
        for (int i = 0; i < word.length; i++) {
            for (int j = word[i].length() - 1; j >= 0; j--) {
                reverse.append(word[i].charAt(j));
            }
            reverse.append(" ");
        }

        return reverse.toString().trim();
    }
}
