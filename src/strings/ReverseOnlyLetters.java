package strings;
/*
https://leetcode.com/problems/reverse-only-letters/
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters
reverse their positions.
 */

public class ReverseOnlyLetters {

    // 9/20/2022 solution
    public String reverseOnlyLetters(String s) {
        StringBuilder reverse = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int index = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isLetter(s.charAt(i))) {
                reverse.append(s.charAt(i));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                result.append(reverse.substring(index, index + 1));
                index++;
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    /*
    Similar idea to initial solution but using a stack for cleaner code
     */
    public String reverseOnlyLetters(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                stringBuilder.append(stack.pop());
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    /*
    Thought to extract only letters in string and reverse them and append them to new stringbuilder
     */
    public String reverseOnlyLetters(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                stringBuilder.append(c);
            }
        }

        stringBuilder.reverse();

        int index = 0;

        StringBuilder reverse = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                reverse.append(stringBuilder.charAt(index));
                index++;
            } else {
                reverse.append(c);
            }
        }

        return reverse.toString();
    }
}
