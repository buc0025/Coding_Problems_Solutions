package strings;
/*
https://leetcode.com/problems/second-largest-digit-in-a-string/
Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.
 */

public class SecondLargestDigit {

    public int secondHighest(String s) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                set.add(Integer.valueOf(s.substring(i, i + 1)));
            }
        }

        int result = -1;

        for (int n : set) {
            list.add(n);
        }

        for (int i = 0; i < list.size()-1; i++) {
            result = list.get(i);
        }

        return result;
    }
}
