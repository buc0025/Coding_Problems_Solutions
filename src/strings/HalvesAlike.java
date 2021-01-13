package strings;
/*
https://leetcode.com/problems/determine-if-string-halves-are-alike/
You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be
the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s
contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.
 */

public class HalvesAlike {

    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int half = s.length()/2;

        if (s.substring(0, half).replaceAll("[aeiou]", "").length() == s.substring(half).replaceAll("[aeiou]","").length()) {
            return true;
        } else {
            return false;
        }
    }
}
