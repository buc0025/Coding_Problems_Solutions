package strings;
/*
https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
Given a sentence that consists of some words separated by a single space, and a searchWord.

You have to check if searchWord is a prefix of any word in sentence.

Return the index of the word in sentence where searchWord is a prefix of this word (1-indexed).

If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word
return -1.

A prefix of a string S is any leading contiguous substring of S.
 */

public class PrefixOfWord {

    public int isPrefixOfWord(String sentence, String searchWord) {
        sentence = sentence.toLowerCase();

        String[] words = sentence.split(" ");
        int index = -1;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() >= searchWord.length()) {
                if (word.substring(0, searchWord.length()).equals(searchWord)) {
                    index = i + 1;
                    break;
                }
            }
        }

        return index;
    }
}
