package arrays;
/*
https://edabit.com/challenge/hYq8J8HJM3pwCFKiZ

Create a function which validates whether a given array alternates between positive and negative numbers.
 */

public class PositivesAndNegatives {

    public static boolean alternateSign(int[] arr) {
        if (arr[0] == 0) {
            return false;
        }

        if (arr[0] > 0) {
            for (int i = 1; i < arr.length; i++) {
                if (i % 2 != 0 && arr[i] >= 0) {
                    return false;
                } else if (i % 2 == 0 && arr[i] <= 0) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < arr.length; i++) {
                if (i % 2 != 0 && arr[i] <= 0) {
                    return false;
                } else if (i % 2 == 0 && arr[i] >= 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
