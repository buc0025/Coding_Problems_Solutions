package Maps_Sets_Tables;
/*
https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
Return the minimum number of steps to make t an anagram of s.
An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 */

public class MinStepsStringAnagram {

    public int minSteps(String s, String t) {
        int[] arr = new int[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            ++arr[s.charAt(i) - 'a'];
            --arr[t.charAt(i) - 'a'];
        }

        for (int a : arr) {
            if (a > 0) {
                count += a;
            }
        }

        return count;
    }

    public int minSteps(String s, String t) {
        int[] arr = new int[26]; // constraint said String s and t contain only lower-case letters

        //Adding and subtracting the appearances of elements in both strings
        for (int i = 0; i < t.length(); i++) {
            ++arr[t.charAt(i) - 'a'];
            --arr[s.charAt(i) - 'a'];
        }

        int count = 0;

        for (int a : arr) {
            // Since we're counting the number of steps to make t an anagram of s,
            // we only need to count missing values
            if (a < 0) {
                count += a;
            }
        }
        return Math.abs(count); // returning absolute value since we only added negative numbers
    }

    public int minSteps(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        // Each key will be given strings' characters
        // value will be the number of occurrences of characters in each string
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            } else {
                sMap.put(s.charAt(i), 1);
            }
            if (tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }

        int sumOfsMapValues = 0; // Used to keep track of sum of values in sMap

        // Comparing the number of occurrences of the same key that appears in
        // both maps and subtracting number of occurrences from sMap to add to sum
        for (Character m : sMap.keySet()) {
            if (tMap.containsKey(m)) {
                if (sMap.get(m) > tMap.get(m)) {
                    sMap.put(m, sMap.get(m) - tMap.get(m));
                } else {
                    sMap.put(m, 0);
                }
            }
            sumOfsMapValues += sMap.get(m);
        }

        return sumOfsMapValues;
    }
}
