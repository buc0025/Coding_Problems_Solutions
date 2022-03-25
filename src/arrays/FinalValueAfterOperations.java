package arrays;
/*
https://leetcode.com/problems/final-value-of-variable-after-performing-operations/submissions/
There is a programming language with only four operations and one variable X:

++X and X++ increments the value of the variable X by 1.
--X and X-- decrements the value of the variable X by 1.
Initially, the value of X is 0.

Given an array of strings operations containing a list of operations, return the final value of X after performing all the
operations.
 */

public class FinalValueAfterOperations {

    //  3/25/2022 solution
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;

        for (String operation : operations) {
            if (operation.contains("++")) {
                result++;
            } else {
                result--;
            }
        }

        return result;
    }

    public int finalValueAfterOperations(String[] operations) {
        int result = 0;

        for (String operation : operations) {
            if (operation.contains("++")) {
                result++;
            } else {
                result--;
            }
        }

        return result;
    }
}
