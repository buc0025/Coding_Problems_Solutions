package Maps_Sets_Tables;
/*
https://leetcode.com/problems/maximum-number-of-balloons/
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.
 */

public class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        if (!text.contains("b") || !text.contains("a") || !text.contains("l") || !text.contains("o") || !text.contains("n")) {
            return 0;
        }

        StringBuilder stringBuilder = new StringBuilder();

        // new string only holds letters in balloon
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                stringBuilder.append(c);
            }
        }

        Map<Character, Integer> map = new HashMap<>(); // keeps track of occurrences of each char

        for (int i = 0; i < stringBuilder.length(); i++) {
            map.put(stringBuilder.charAt(i), map.getOrDefault(stringBuilder.charAt(i), 0) + 1);
        }

        // 'l's and 'o's are the only letters in balloon that occurs twice
        map.put('l', map.get('l') / 2);
        map.put('o', map.get('o') / 2);

        int num = 2000; // max number in constraint

        // lowest occurrence should equal number occurrence of 'balloon'
        for (char n : map.keySet()) {
            num = Math.min(map.get(n), num);
        }

        return num;
    }
}
