package strings;
/*
https://leetcode.com/problems/maximum-number-of-words-you-can-type/
There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all
distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.
 */

public class CanBeTypedWords {

    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        boolean canBeTyped = true;
        String[] words = text.split(" ");
        Set<String> letters = new HashSet<>();

        for (int i = 0; i < brokenLetters.length(); i++) {
            letters.add(brokenLetters.substring(i, i + 1));
        }

        for (String word : words) {

            for (int i = 0; i < word.length(); i++) {
                if (letters.contains(word.substring(i, i + 1))) {
                    canBeTyped = false;
                    break;
                }
            }

            if (canBeTyped) {
                count++;
            }

            canBeTyped = true;
        }

        return count;
    }
}
