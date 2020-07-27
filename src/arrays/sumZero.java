package arrays;

/*
https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
Given an integer n, return any array containing n unique integers such that they add up to 0.
 */

public class sumZero {

    public int[] sumZero(int n) {
        int[] arr = new int[n];  //3
        int posHalf = n / 2;        // 1
        int negHalf = n / 2;        // 1

        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = posHalf;
            posHalf--;
        }
        for (int i = arr.length / 2; i < arr.length; i++) {
            arr[i] = negHalf * (-1);
            negHalf--;
        }
        if (n % 2 ==1) {
            arr[arr.length-1] = 0;
        }
        return arr;
    }
}
