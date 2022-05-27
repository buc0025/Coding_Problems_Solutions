package arrays;
/*
https://edabit.com/challenge/CR7uvWLiKNaZeoj4R

Create a function that takes an array of three numbers and returns the Least Common Multiple (LCM).

The LCM is the smallest positive number that is a multiple of two or more numbers. In our case, we are dealing with three numbers.

Multiples of 3 are: 3, 6, 9, 12, and so on.
Multiples of 4 are: 4, 8,12, and so on.
Multiples of 12 are: 12, 24, 36, and so on.
Thus, the least common multiple of 3, 4, and 12 is 12.
 */

public class LcmOfThree {

    // 5/26/2022 solution
    public static int lcmOfThree(int[] arr) {
        int max = Math.max(arr[0], Math.max(arr[1], arr[2]));
        int maxInt = Integer.MAX_VALUE / max;
        int result = 0;
        int n = max;

        for (int i = 2; i < maxInt; i++) {
            if (max % arr[0] == 0 && max % arr[1] == 0 && max % arr[2] == 0) {
                result = max;
                return result;
            }
            max = n * i;
        }
        return result;
    }
}
