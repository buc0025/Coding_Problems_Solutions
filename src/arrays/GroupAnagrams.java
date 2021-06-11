package arrays;
/*
https://leetcode.com/problems/group-anagrams/
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original
letters exactly once.
 */

public class GroupAnagrams {

    // Incorrect attempt because words that have been visited already reappear in List<List<String>>
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            List<String> words = new ArrayList<>();
            for (int j = i + 1; j < strs.length; j++) {
                if (anagram(strs[i], strs[j])) {
                    words.add(strs[j]);
                }
            }
            words.add(strs[i]);
            list.add(words);
        }

        return list;
    }

    public boolean anagram(String word, String word1) {
        if (word.length() != word1.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
            arr[word1.charAt(i) - 'a']--;
        }

        for (int a : arr) {
            if (a != 0) {
                return false;
            }
        }

        return true;
    }
}
