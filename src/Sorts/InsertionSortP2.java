package Sorts;
/*
https://www.hackerrank.com/challenges/insertionsort2/problem
At each iteration, it should print the array as space-separated integers on a separate line.
Ex.
3 4 7 5 6 2 1
3 4 7 5 6 2 1
3 4 5 7 6 2 1
3 4 5 6 7 2 1
2 3 4 5 6 7 1
1 2 3 4 5 6 7
 */

public class InsertionSortP2 {

    static void insertionSort2(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
