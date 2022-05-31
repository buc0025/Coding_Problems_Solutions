package strings;
/*
https://leetcode.com/problems/ransom-note/

Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.
 */

public class CanConstruct {

    // 5/27/2022 solution
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            if (arr[magazine.charAt(i) - 'a'] > 0) {
                arr[magazine.charAt(i) - 'a']--;
            }
        }

        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
