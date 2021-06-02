package strings;
/*
https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
The letter value of a letter is its position in the alphabet starting from 0 (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, etc.).

The numerical value of some string of lowercase English letters s is the concatenation of the letter values of each letter in s,
which is then converted into an integer.

For example, if s = "acb", we concatenate each letter's letter value, resulting in "021". After converting it, we get 21.
You are given three strings firstWord, secondWord, and targetWord, each consisting of lowercase English letters 'a' through 'j'
inclusive.

Return true if the summation of the numerical values of firstWord and secondWord equals the numerical value of targetWord, or
false otherwise.
 */

public class IsSumEqual {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = 0;
        int second = 0;
        int target = 0;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < firstWord.length(); i++) {
            stringBuilder.append((int) firstWord.charAt(i) - 97);
        }

        first = Integer.valueOf(stringBuilder.toString());
        stringBuilder.setLength(0);

        for (int i = 0; i < secondWord.length(); i++) {
            stringBuilder.append((int) secondWord.charAt(i) - 97);
        }

        second = Integer.valueOf(stringBuilder.toString());
        stringBuilder.setLength(0);

        for (int i = 0; i < targetWord.length(); i++) {
            stringBuilder.append((int) targetWord.charAt(i) - 97);
        }

        target = Integer.valueOf(stringBuilder.toString());

        return first + second == target ? true : false;
    }

    // Wrote a separate method to calculate the numerical value of a string
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        if (stringToInt(firstWord) + stringToInt(secondWord) == stringToInt(targetWord)) {
            return true;
        } else {
            return false;
        }
    }

    public static int stringToInt(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            stringBuilder.append((int) word.charAt(i) - 97);
        }

        return Integer.valueOf(stringBuilder.toString());
    }
}
