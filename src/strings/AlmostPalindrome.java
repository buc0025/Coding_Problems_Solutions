package strings;

/*
https://edabit.com/challenge/E9AHcnWg7fDfardLF

A string is an almost-palindrome if, by changing only one character, you can make it a palindrome. Create a function that returns
true if a string is an almost-palindrome and false otherwise.
 */

public class AlmostPalindrome {

    public static boolean almostPalindrome(String str) {
        int almost = 0;
        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                almost++;
            }
            l++;
            r--;
        }

        return almost == 1 ? true : false;
    }
}
