package arrays;
/*
https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

A sentence is a list of words that are separated by a single space with no leading or trailing spaces.

You are given an array of strings sentences, where each sentences[i] represents a single sentence.

Return the maximum number of words that appear in a single sentence.
 */

public class MostWordsFound {

    //  3/26/2022 solution
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;

        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            maxWords = Math.max(words.length, maxWords);
        }

        return maxWords;
    }

    //  3/26/2022 solution
    public int mostWordsFound(String[] sentences) {
        int max = 1;

        for (int i = 0; i < sentences.length; i++) {
            int space = 1;
            for (int j = 0; j < sentences[i].length(); j++) {
                if (sentences[i].charAt(j) == ' ') {
                    space++;
                }
            }
            max = Math.max(max, space);
        }

        return max;
    }
}
