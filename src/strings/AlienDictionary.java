package strings;
/*
https://leetcode.com/problems/verifying-an-alien-dictionary/
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the
alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words
are sorted lexicographicaly in this alien language.
 */

public class AlienDictionary {

    // 9/28/2022 unfinished solution
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }

        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i - 1], words[i], order)) {
                return false;
            }
        }

        return true;
    }

    public boolean compare(String word1, String word2, String order) {
        int index = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (i < word2.length()) {
                int a = order.indexOf(word1.charAt(i));
                int b = order.indexOf(word2.charAt(i));
                if (a == b) {
                    index++;
                    continue;
                } else if (a < b) {
                    return true;
                }
            }
        }

        if (index == word1.length()) {
            return true;
        }

        return false;
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        // Assign new values in ascending order for new alphabet
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        // Comparing 2 words at a time to see if they're in sorted order
        for (int i = 1; i < words.length; i++) {
            int len1 = words[i - 1].length();
            int len2 = words[i].length();
            int index = 0;
            while (len1 > 0 && len2 > 0) {
                // If the character at index i for word 1 is greater than word 2 then it's not sorted correctly
                if (map.get(words[i - 1].charAt(index)) > map.get(words[i].charAt(index))) {
                    return false;
                }
                // If the character at index i for word 2 is greater than word 1 then it's sorted correctly and we can move onto
                // the next word
                if (map.get(words[i - 1].charAt(index)) < map.get(words[i].charAt(index))) {
                    break;
                }
                len1--;
                len2--;
                index++;

                // If the characters in both words has been equal until the end of word 2 and there's still characters left in
                // word 1 then it's not sorted.
                if (len2 == 0 && len1 > 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
