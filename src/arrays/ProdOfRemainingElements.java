package arrays;
/*
https://edabit.com/challenge/EjQM5woRAhYEmuGFp

Write a function that returns true if you can partition an array into one element and the rest, such that this element is equal to
the product of all other elements excluding itself.
 */

public class ProdOfRemainingElements {

    public static boolean canPartition(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int min = arr[0];
        int maxProd = arr[0];
        int minProd = arr[arr.length -1];

        for (int i = 1; i < arr.length - 1; i++) {
            maxProd *= arr[i];
            minProd *= arr[i];
        }

        if (min == minProd || max == maxProd) {
            return true;
        }

        return false;
    }
}
