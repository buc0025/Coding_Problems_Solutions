package arrays;
/*
https://leetcode.com/problems/flipping-an-image/
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0]
horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1]
results in [1, 0, 0].
 */

public class FlippingImage {

    // 8/16/2022 solution
    public int[][] flipAndInvertImage(int[][] image) {
        int len = image.length;
        int[][] matrix = new int[len][len];

        for (int i = 0; i < len; i++) {
            int index = 0;
            for (int j = len - 1; j >= 0; j--) {
                matrix[i][index] = image[i][j];
                index++;
            }

            for (int k = 0; k < len; k++) {
                if (matrix[i][k] == 0) {
                    matrix[i][k] = 1;
                } else {
                    matrix[i][k] = 0;
                }
            }
        }

        return matrix;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int[][] ans = new int[A.length][A.length];
        int index = 0;

        // Flipping horizontally by assigning end elements to front
        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - 1; j >= 0; j--) {
                ans[i][index] = A[i][j];
                index++;
            }
            index = 0;
        }

        // Inverting image by turning 1 into 0 and vice versa
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                if (ans[i][j] == 0) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
