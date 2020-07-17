package strings;

/*
https://leetcode.com/problems/check-if-n-and-its-double-exist/
Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 */

public class DoubleExists {

    public boolean checkIfExist(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] *2 && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

}
