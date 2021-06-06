package arrays;
/*
https://leetcode.com/problems/ransom-note/
Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.
 */

public class RansomNote {

    // Top solution only uses 2 loops. The first loop increments the letters in the magazine. The second loop decrements the
    // elements in the array which appears in the ransom note. If the elements in the array is less than 0 then it returns false
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
