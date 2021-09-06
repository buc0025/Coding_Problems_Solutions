package arrays;
/*
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are
positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 */

import java.util.Arrays;

public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        int[] arr = new int[mat.length];
        int[] clone = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    soldiers++;
                } else {
                    break;
                }
            }
            arr[i] = soldiers;
        }

        clone = arr.clone();
        Arrays.sort(clone);

        int index = 0;

        while (index < k) {

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == clone[index]) {
                    result[index] = i;
                    arr[i] = -1;
                    index++;
                    break;
                }
            }
        }

        return result;
    }
}
