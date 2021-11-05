package strings;
/*
https://edabit.com/challenge/NGnsMw8CG8gxEFW7w

We can assign a value to each character in a word, based on their position in the alphabet (a = 1, b = 2, ... , z = 26). A
balanced word is one where the sum of values on the left-hand side of the word equals the sum of values on the right-hand side.
For odd length words, the middle character (balance point) is ignored.

Write a function that returns true if the word is balanced, and false if it's not.
 */

public class BalancedWords {

    public static boolean balanced(String word) {
        int left = 0;
        int right = 0;
        int firstHalf = word.length() / 2;
        int secondHalf = word.length() / 2;

        if (word.length() % 2 != 0) {
            secondHalf = word.length() / 2 + 1;
        }

        for (int i = 0; i < firstHalf; i++) {
            int n = (int) word.charAt(i);
            left += n - 96;
        }

        for (int i = secondHalf; i < word.length(); i++) {
            int n = (int) word.charAt(i);
            right += n - 96;
        }

        return left == right;
    }
}
