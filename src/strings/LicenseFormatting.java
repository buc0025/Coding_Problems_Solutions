package strings;
/*
https://leetcode.com/problems/license-key-formatting/
You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is
separated into N+1 groups by N dashes.

Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first
group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted
between two groups and all lowercase letters should be converted to uppercase.

Given a non-empty string S and a number K, format the string according to the rules described above.
 */

public class LicenseFormatting {

    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        s = s.replaceAll("-", "");
        StringBuilder stringBuilder = new StringBuilder();
        int front = s.length() % k;

        if (s.length() == 1) {
            return s.substring(0);
        }

        if (front == 0) {
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(s.charAt(i));
                if ((i + 1) % k == 0 && i != s.length() - 1) {
                    stringBuilder.append('-');
                }
            }
        } else {
            stringBuilder.append(s.substring(0, front));
            stringBuilder.append('-');
            s = s.substring(front);
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(s.charAt(i));
                if ((i + 1) % k == 0 && i != s.length() - 1) {
                    stringBuilder.append('-');
                }
            }
        }

        return stringBuilder.toString();
    }
}
