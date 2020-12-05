package Sorts;
/*
https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
There are 3n piles of coins of varying size, you and your friends will take piles of coins as follows:

In each step, you will choose any 3 piles of coins (not necessarily consecutive).
Of your choice, Alice will pick the pile with the maximum number of coins.
You will pick the next pile with maximum number of coins.
Your friend Bob will pick the last pile.
Repeat until there are no more piles of coins.
Given an array of integers piles where piles[i] is the number of coins in the ith pile.

Return the maximum number of coins which you can have.
 */

public class MaximumCoins {

    public int maxCoins(int[] piles) {
        int sum = 0;
        int numberOfPiles = piles.length / 3; // Arrange the array so that the third person only gets the elements in the front

        Arrays.sort(piles);

        for (int i = piles.length - 2; i >= numberOfPiles; i-=2) {
            sum += piles[i];
        }

        return sum;
    }

    //**************Uses built-in sort for arrays*******
    public int maxCoins(int[] piles) {
        int num = piles.length / 3;     //divides coin piles by number of people (3)
        int result = 0;

        Arrays.sort(piles);

        for (int i = piles.length - 2; i >= num; i-= 2) {   //you will get second largest coin pile in each iteration
            result += piles[i];                             //after everyone picks their designated pile
        }
        return result;
    }
    //***********Uses Merge Sort to sort array**********
    public int maxCoins(int[] piles) {
        int num = piles.length / 3;
        int result = 0;

        // Sorts array using merge sort implemented below
        sort(piles, 0, piles.length - 1);

        for (int i = piles.length - 2; i >= num; i-= 2) {
            result += piles[i];
        }
        return result;
    }
    //merge sort implementation from Geeks For Geeks
    static void merge(int[] arr, int l, int m, int r) {
        int lLen = m - l + 1;
        int rLen = r - m;

        int[] lArr = new int[lLen];
        int[] rArr = new int[rLen];

        for (int i = 0; i < lLen; i++) {
            lArr[i] = arr[l + i];
        }
        for (int j = 0; j < rLen; j++) {
            rArr[j] = arr[m + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = l;

        while (i < lLen && j < rLen) {
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }
        while (i < lLen) {
            arr[k] = lArr[i];
            i++;
            k++;
        }
        while (j < rLen) {
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }

    static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
}
