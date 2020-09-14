package Sorts;
/*
https://www.hackerrank.com/challenges/insertionsort1/problem
Given a sorted list with an unsorted number e in the rightmost cell, can you write some simple code to insert e into
the array so that it remains sorted?
Ex.
Starting array : [1, 2, 4, 5, 3]
Output:
1 2 4 5 5
1 2 4 4 5
1 2 3 4 5
 */

public class InsertionSortP1 {

    static void insertionSort1(int n, int[] arr) {
        int end = arr[n - 1];

        while (n - 2 >= 0 && end < arr[n - 2]) {
            arr[n - 1] = arr[n - 2];
            n = n - 1;

            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

        arr[n - 1] = end;

        for (int a : arr) {
            System.out.print(a + " ");
        }

    }
}
