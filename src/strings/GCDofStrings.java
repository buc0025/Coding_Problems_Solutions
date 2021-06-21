package strings;
/*
https://leetcode.com/problems/greatest-common-divisor-of-strings/
For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */

public class GCDofStrings {

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 >= len2) {
            /*
            Since we're looking for the largest substring, we start at substring(0, string length) and work our way down from length
            of string.
             */
            for (int i = len2; i >= 1; i--) {
                StringBuilder string1 = new StringBuilder();
                StringBuilder string2 = new StringBuilder();
                if (len1 % i == 0 && len2 % i == 0) { // The substring has to fit in both given strings
                    int n = len1 / i;
                    int m = len2 / i;
                    while (n > 0) {
                        string1.append(str2.substring(0, i));
                        n--;
                        if (m > 0) {
                            string2.append(str2.substring(0, i));
                            m--;
                        }
                    }
                }
                if (str1.equals(string1.toString()) && str2.equals(string2.toString())) {
                    return str2.substring(0, i);
                }
            }
        } else {
            for (int i = len1; i >= 1; i--) {
                StringBuilder string2 = new StringBuilder();
                StringBuilder string1 = new StringBuilder();
                if (len1 % i == 0 && len2 % i == 0) {
                    int n = len2 / i;
                    int m = len1 / i;
                    while (n > 0) {
                        string2.append(str1.substring(0, i));
                        n--;
                        if (m > 0) {
                            string1.append(str1.substring(0, i));
                            m--;
                        }
                    }
                }
                if (str2.equals(string2.toString()) && str1.equals(string1.toString())) {
                    return str1.substring(0, i);
                }
            }
        }
        
        return "";
    }
}
