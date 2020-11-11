package Maps_Sets_Tables;
/*
https://www.hackerrank.com/challenges/anagram/problem
In this challenge, you will be given a string. You must split it into two contiguous substrings, then determine the
minimum number of characters to change to make the two substrings into anagrams of one another.
 */

public class HackerAnagram {

    // The problem seemed pretty simple in the beginning until I tried testing different test cases like "xaxbbbxx",
    // the answer is supposed to be 1 but I was getting 0 because I was only using the first half of the string in a set.
    // I then tried using 2 sets but that doesn't count the number of times a certain character appears in the string.

    static int anagram(String s) {
        int ans = 0;

        // Initial thought was to only have first half of string in a set and use it to compare second half of the
        // string to see how many characters they're off by
        Set<Character> set = new HashSet<>();

        // There's no way the two substrings of original string can become anagrams if they're not the same length
        if (s.length() % 2 == 1) {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {
            // Only populating set with first half of string
            if (i < s.length() / 2) {
                set.add(s.charAt(i));
            // Comparing set with second half of string to look for number of characters to chance to make the
            // two substrings anagrams
            } else if (!set.contains(s.charAt(i))){
                ans++;
            }
        }

        return ans;
    }

}
