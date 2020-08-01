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
        String[] pat = pattern.split("");

        if (arr.length != pat.length || pattern.length() == 0) {
            return false;
        }

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(pat[i])) {
                if (!map.get(pat[i]).equals(arr[i])) {
                    return false;
                }
            }
            if (map.containsValue(arr[i])) {
                if (!arr[i].equals(map.get(pat[i]))) {
                    return false;
                }
            }
            map.put(pat[i], arr[i]);
        }
        return true;
    }
}
