package Recursion;
/*
https://leetcode.com/problems/unique-paths/
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the
grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 */

public class UniquePaths {

    // Incorrect solution due to exceeding time limit. Solution works but answer calls for dynamic programming instead of recursion
    public int uniquePaths(int m, int n) {
        if (m <= 0) {
            return 0;
        }

        if (n <= 0) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        int right = uniquePaths(m, n - 1);
        int down = uniquePaths(m - 1, n);

        return right + down;
    }
}
