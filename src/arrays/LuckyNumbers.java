package arrays;
/*
https://leetcode.com/problems/lucky-numbers-in-a-matrix/
Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 */

public class LuckyNumbers {

    /*
    I utilized a set to hold the minimum element in each row and another list to hold the maximum element of each column. Since
    all numbers in the matrix distinct, if any number appears in both sets then it will get added to the final list.
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> minRow = new HashSet<>();
        Set<Integer> maxCol = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int row = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] <= row) {
                    row = matrix[i][j];
                }
            }
            minRow.add(row);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int col = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] >= col) {
                    col = matrix[j][i];
                }
            }
            maxCol.add(col);
        }

        for (int m : maxCol) {
            if (minRow.contains(m)) {
                list.add(m);
            }
        }

        return list;
    }
}
