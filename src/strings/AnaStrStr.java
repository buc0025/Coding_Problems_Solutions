package strings;
/*
https://edabit.com/challenge/ChqsAuCYkGm7x2Jyw

Create a function that takes two strings and determines if an anagram of the first string is in the second string. Anagrams of
"bag" are "bag", "bga", "abg", "agb", "gab", "gba". Since none of those anagrams are in "grab", the answer is false. A "g", "a",
and "b" are in the string "grab", but they're split up by the "r".
 */

public class AnaStrStr {

    // 5/24/2022 solution
    public static boolean anaStrStr(String needle, String haystack) {
        int[] needleArr = new int[26];
        for (int i = 0; i < needle.length(); i++) {
            needleArr[needle.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String inHaystack = haystack.substring(i, i + needle.length());
            boolean isAnagram = true;
            int[] hayArr = new int[26];
            for (int j = 0; j < inHaystack.length(); j++) {
                hayArr[inHaystack.charAt(j) - 'a']++;
            }

            for (int k = 0; k < needleArr.length; k++) {
                if (hayArr[k] != needleArr[k]) {
                    isAnagram = false;
                }
            }

            if (isAnagram) {
                return true;
            }
        }
        return false;
    }
}
