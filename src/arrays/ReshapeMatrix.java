package arrays;
/*
https://leetcode.com/problems/reshape-the-matrix/
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but
keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and
column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the
original matrix.
 */

public class ReshapeMatrix {
    /*
    Leetcode solution shows I could've used a queue to hold all elements of the original matrix and take it out for new matrix.
    There's also another solution that doesn't require extra space by creating a row and column variable for the new matrix.
     */

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }

        int[][] arr = new int[r][c];

        List<Integer> list = new ArrayList<>(); // Used to store all elements of original matrix

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                list.add(nums[i][j]);
            }
        }

        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = list.get(index);
                index++;
            }
        }

        return arr;
    }
}
