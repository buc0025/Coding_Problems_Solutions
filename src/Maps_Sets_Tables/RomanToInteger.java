package Maps_Sets_Tables;
/*
https://leetcode.com/problems/roman-to-integer/
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the
number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the
number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
 */

public class RomanToInteger {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.containsKey(s.substring(i, i + 2))) {
                sum += map.get(s.substring(i, i + 2));
                i++;
            } else {
                sum += map.get(s.substring(i, i + 1));
            }
        }

        return sum;
    }
}
