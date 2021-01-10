package arrays;
/*
https://leetcode.com/problems/01-matrix/
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
 */

public class UpdateMatrix {

    // Incorrect attempt at random mock interview problem
    public int[][] updateMatrix(int[][] matrix) {
        int[][] arr = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int right = 0;
                int left = 0;
                int up = 0;
                int down = 0;

                if (matrix[i][j] == 0) {
                    arr[i][j] = 0;
                }
                // Checks the right side of 1
                if (matrix[i][j] == 1 && j < matrix[i].length - 1) {
                    for (int k = j; k < matrix[i].length; k++) {
                        if (arr[i][k] == 1) {
                            ++right;
                        } else {
                            break;
                        }
                    }
                }
                // Checks the left side of 1
                if (matrix[i][j] == 1 && j > 0) {
                    for (int k = j; k >= 0; k--) {
                        if (arr[i][k] == 1) {
                            ++left;
                        } else {
                            break;
                        }
                    }
                }
                // Checks the top of 1
                if (matrix[i][j] == 1 && i > 0) {
                    for (int k = i; k >= 0; k--) {
                        if (arr[k][j] == 1) {
                            ++up;
                        } else {
                            break;
                        }
                    }
                }
                // Checks the bottom of 1
                if (matrix[i][j] == 1 && i < matrix.length - 1) {
                    for (int k = i; k < matrix.length; k++) {
                        if (arr[k][j] == 1) {
                            ++down;
                        } else {
                            break;
                        }
                    }
                } else {
                    int[] newArr = {up, down, left, right};
                    Arrays.sort(newArr);
                    int num = 0;
                    for (int n : newArr) {
                        if (n != 0) {
                            num = n;
                        }
                        break;
                    }
                    arr[i][j] = num;
                }
            }
        }
        return arr;
    }
}
