package arrays;
/*
https://edabit.com/challenge/MfkWhtu67fD5d5YM2

Create a function that determines whether it is possible to build a palindrome from the characters in a string.
 */

public class PossiblePalindrome {

    // 6/19/2022 solution
    public static boolean possiblePalindrome(String str) {
        boolean oddLen = str.length() % 2 == 1;
        int[] letters = new int[26];
        int odds = 0;

        for (int i = 0; i < str.length(); i++) {
            letters[str.charAt(i) - 'a']++;
        }

        for (int letter : letters) {
            if (letter % 2 == 1) {
                odds++;
            }
        }

        if (odds > 1) {
            return false;
        }

        if (oddLen) {
            return odds == 1;
        }

        return true;
    }
}
