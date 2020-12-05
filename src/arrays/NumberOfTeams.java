package arrays;
/*
https://leetcode.com/problems/count-number-of-teams/
There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 */

public class NumberOfTeams {

    // Idea is to compare the left elements and right elements with the index you're on and multiple both sides if they fit the
    // criteria of (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
    public int numTeams(int[] rating) {
        int sum = 0;

        for (int i = 1; i < rating.length - 1; i++) {
            int left = 0;
            int right = 0;
            int left1 = 0;
            int right1 = 0;

            for (int j = 0; j < rating.length; j++) {
                // Checks for ascending order
                if (j < i && rating[j] < rating[i]) {
                    left++;
                }
                // Checks for ascending order
                if (j > i && rating[j] > rating[i]) {
                    right++;
                }
                // Checks for descending order
                if (j < i && rating[j] > rating[i]) {
                    left1++;
                }
                // Checks for descending order
                if (j > i && rating[j] < rating[i]) {
                    right1++;
                }
            }
            sum += (left * right) + (left1 * right1);
        }

        return sum;
    }

    public int numTeams(int[] rating) {
        int count = 0;

        // Starting with the middle index of the possible 3 numbers instead of the start
        for (int j = 1; j < rating.length-1; j++) {

            // Variables reset back to 0 after each iteration
            int leftSmall = 0; // Checks if the left side of middle index is smaller.
            int rightBig = 0;  // Checks if the right side of middle index is bigger.
            int leftBig = 0;   // Checks if the left side of middle index is bigger.
            int rightSmall = 0;  // Checks if the right side of middle index is smaller.

            // Checking the left side of the middle index
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftSmall++;
                }
                if (rating[i] > rating[j]) {
                    leftBig++;
                }
            }

            // Checking the right side of the middle index
            for (int k = j + 1; k < rating.length; k++) {
                if (rating[k] > rating[j]) {
                    rightBig++;
                }
                if (rating[k] < rating[j]) {
                    rightSmall++;
                }
            }
            // Adds possible combinations for increasing and decreasing order
            count += leftSmall * rightBig + leftBig * rightSmall;
        }

        return count;
    }

    public int numTeams(int[] rating) {
        int count = 0;

        for (int i = 0; i < rating.length-2; i++) {
            for (int j = i + 1; j < rating.length-1; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        count++;
                    }
                    if (rating [i] > rating[j] && rating[j] > rating[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
