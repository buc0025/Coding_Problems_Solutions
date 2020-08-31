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