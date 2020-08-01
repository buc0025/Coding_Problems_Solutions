package Maps_Sets_Tables;
import java.util.*;
/*
https://leetcode.com/problems/valid-anagram/
Given two strings s and t , write a function to determine if t is an anagram of s.
 */

public class Anagram {

    public boolean isAnagram1(String s, String t) {

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        for (char a : arr1) {
            if (map1.containsKey(a)) {
                map1.put(a, map1.get(a) + 1);
            } else {
                map1.put(a, 1);
            }
        }
        for (char a : arr2) {
            if (map2.containsKey(a)) {
                map2.put(a, map2.get(a) + 1);
            } else {
                map2.put(a, 1);
            }
        }
        return map1.equals(map2);
    }

    public boolean isAnagram2(String s, String t) {

        char[] arr2 = s.toCharArray();
        char[] arr1 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
