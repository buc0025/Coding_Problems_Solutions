package arrays;
/*
https://leetcode.com/problems/string-matching-in-an-array/
Given an array of string words. Return all strings in words which is substring of another word in any order.

String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
 */

public class StringMatching {

    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (matchSubstring(words[i], words[j]) && !list.contains(words[i])) {
                    list.add(words[i]);
                }
            }
        }
        return list;
    }

    public static boolean matchSubstring(String shorter, String longer) {
        if (shorter.length() >= longer.length()) {
            return false;
        }

        int sLen = shorter.length();
        for (int i = 0; i <= longer.length() - sLen; i++) {
            if (longer.substring(i, i + sLen).equals(shorter)) {
                return true;
            }
        }

        return false;
    }
}
