package arrays;
/*
https://edabit.com/challenge/akLRnxrtrAsnyYuZb

Write a function that, given the start and end values, returns an array containing all the numbers inclusive to that range.
 */

public class ReversibleInclusiveList {

    // 9/26/2022 solution
    public static int[] reversibleInclusiveList(int start,int end) {
        int len = Math.abs(start - end) + 1;
        int[] arr = new int[len];

        if (end > start) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = start++;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = start--;
            }
        }

        return arr;
    }
}
