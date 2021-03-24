package strings;
/*
https://leetcode.com/problems/reverse-vowels-of-a-string/
Write a function that takes a string as input and reverse only the vowels of a string.
 */

public class ReverseVowels {

    public String reverseVowels(String s) {
        StringBuilder vowels = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int vowelsIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (sc == 'a' || sc == 'e' || sc == 'i' || sc == 'o' || sc == 'u' ||
                    sc == 'A' || sc == 'E' || sc == 'I' || sc == 'O' || sc == 'U') {
                vowels.append(sc);
            }
        }

        vowels.reverse();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (sc == 'a' || sc == 'e' || sc == 'i' || sc == 'o' || sc == 'u' ||
                    sc == 'A' || sc == 'E' || sc == 'I' || sc == 'O' || sc == 'U') {
                result.append(vowels.charAt(vowelsIndex));
                vowelsIndex++;
            } else {
                result.append(sc);
            }

        }

        return result.toString();
    }
}
