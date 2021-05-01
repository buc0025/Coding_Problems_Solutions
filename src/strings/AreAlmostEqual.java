package strings;
/*
https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not
necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings.
Otherwise, return false.
 */

public class AreAlmostEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        int diff = 0;
        int[] nums = new int[2];
        int index = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (!s1.substring(i, i + 1).equals(s2.substring(i, i + 1))) {
                diff++;
                if (index < 2) {
                    nums[index] = i;
                    index++;
                }
            }
        }

        if (diff > 2 || diff == 1) {
            return false;
        } else if (diff == 0) {
            return true;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            if (!s1.substring(i, i + 1).equals(s2.substring(i, i + 1))) {
                stringBuilder.append(s1.charAt(nums[--index]));
            } else {
                stringBuilder.append(s1.charAt(i));
            }
        }

        return stringBuilder.toString().equals(s2);
    }
}
