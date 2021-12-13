package arrays;
/*
https://edabit.com/challenge/y93Q6YRPwFgZx84Xj

In each input array, every number repeats at least once, except for two. Write a function that returns the two unique numbers.
 */
public class TwoDistinctElements {

    public static int[] returnUnique(int[] n) {
        int first = 0;
        int second = 0;

        int[] arr = new int[n.length];

        for (int i = 0; i < n.length; i++) {
            int count = 1;
            for (int j = 0; j < n.length; j++) {
                if (n[i] == n[j]) {
                    arr[i] = count++;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 && first == 0) {
                first = n[i];
            } else if (arr[i] == 1 && first != 0) {
                second = n[i];
            }
        }

        return new int[] {first, second};
    }
}
