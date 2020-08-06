package Maps_Sets_Tables;
import java.util.*;

/*
https://edabit.com/challenge/6THnWXvQrhRrEErtb
Given what is supposed to be typed and what is actually typed, write a function that returns the broken key(s).
Examples:
findBrokenKeys("happy birthday", "hawwy birthday") ➞ ["p"]
findBrokenKeys("starry night", "starrq light") ➞ ["y", "n"]
findBrokenKeys("beethoven", "affthoif5") ➞ ["b", "e", "v", "n"]
 */

public class BrokenKeyboard {
    public static String[] findBrokenKeys(String str1, String str2) {
        String result = "";
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                result += str1.charAt(i);
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < result.length(); i++) {
            set.add(result.substring(i, i+1));
        }
        int index = 0;
        String[] answer = new String[set.size()];
        for (int i = 0; i < str1.length(); i++) {
            if (set.contains(str1.substring(i, i +1))) {
                answer[index] = str1.substring(i, i+1);
                index++;
                set.remove(str1.substring(i, i+1));
            }
        }
        return answer;
    }
}
