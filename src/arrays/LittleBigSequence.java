package arrays;
/*
https://edabit.com/challenge/hEbyZPTpxt4AtmmhP

Given that 5 is at position 1, create a function that returns the number found at position n in the sequence.
 */

public class LittleBigSequence {

    public static int littleBig(int n) {
        if (n == 1) {
            return 5;
        }

        if (n == 2) {
            return 100;
        }

        int[] arr = new int[n];

        int odd = 5;
        int even = 100;

        arr[0] = odd;
        arr[1] = even;

        for (int i = 2; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = ++odd;
            } else {
                arr[i] = even * 2;
                even *= 2;
            }
        }

        return arr[n-1];
    }
}
