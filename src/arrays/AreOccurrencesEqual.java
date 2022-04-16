package arrays;
/*
https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).
 */

public class AreOccurrencesEqual {

    // 4/15/2022 solution
    public boolean areOccurrencesEqual(String s) {
        int[] arr = new int[26];
        int occurrences = 0;

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (occurrences != 0) {
                if (arr[i] != 0 && arr[i] != occurrences) {
                    return false;
                }
            }
            if (arr[i] != 0) {
                occurrences = arr[i];
            }
        }

        return true;
    }

    // 4/15/2022 solution
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        int occurrences = map.get(s.charAt(0));

        for (Character c : map.keySet()) {
            if (map.get(c) != occurrences) {
                return false;
            }
        }

        return true;
    }

    public boolean areOccurrencesEqual(String s) {
        int[] alphabet = new int[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 97]++;
        }

        for (int a : alphabet) {
            if (a != 0) {
                count = a;
                break;
            }
        }

        for (int a : alphabet) {
            if (a != 0 && a != count) {
                return false;
            }
        }

        return true;
    }
}
