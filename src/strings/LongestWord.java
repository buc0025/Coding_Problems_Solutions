package strings;
/*
https://edabit.com/challenge/LzY7r73f9xKhKvtki

Write a function that finds the longest word in a sentence. If two or more words are found, return the first longest word.
Characters such as apostophe, comma, period (and the like) count as part of the word (e.g. O'Connor is 8 characters long).
 */

public class LongestWord {

    public static String longestWord(String phrase) {
        String[] words = phrase.split(" ");
        int len = 0;

        for (String word : words) {
            if (word.length() > len) {
                len = word.length();
            }
        }

        for (String word : words) {
            if (word.length() == len) {
                return word;
            }
        }

        return "";
    }
}
