package Maps_Sets_Tables;
import java.util.*;

/*
https://leetcode.com/problems/word-pattern/
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true
 */

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        if (pattern.length() != arr.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map1 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String string = arr[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(string)) {
                    return false;
                }
            }
            else if (map1.containsKey(string)) {
                if (!map1.get(string).equals(c)) {
                    return false;
                }
            } else {
                map.put(c, string);
                map1.put(string, c);
            }
        }

        return true;
    }

    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        if (pattern.length() != arr.length) {
            return false;
        }

        Map<Character, String> sMap = new HashMap<>();
        Map<String, Character> patternMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = arr[i];
            if (!sMap.containsKey(c)) {
                sMap.put(c, word);
            }
            if (!patternMap.containsKey(word)) {
                patternMap.put(word, c);
            }
            if (!sMap.get(c).equals(word) || !patternMap.get(word).equals(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");

        if (arr.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(arr[i])) {
                    return false;
                }
            }
            if (map.containsValue(arr[i])) {
                if (!arr[i].equals(map.get(c))) {
                    return false;
                }
            }
            map.put(c, arr[i]); //inputs first elements before checking if statements
        }
        return true;
    }
}
