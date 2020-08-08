package arrays;
/*
https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/java
Given a string of words, you need to find the highest scoring word.
Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
You need to return the highest scoring word as a string.
If two words score the same, return the word that appears earliest in the original string.
All letters will be lowercase and all inputs will be valid.
 */

public class HighestScoringWord {

    public static String high(String s) {
        String[] arr = s.split(" ");
        int[] nums = new int[arr.length];
        int sum = 0;
        String result = "";

        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = 0; j < arr[i].length(); j++) {

                sum += arr[i].charAt(j)-96;
            }
            nums[i] = sum;
        }

        int max = nums[0];
        for (int i = nums.length -1; i >= 0; i--) {
            if (nums[i] >= max) {
                max = nums[i];
                result = arr[i];
            }
        }
        return result;
    }
}
