package arrays;
/*
https://leetcode.com/problems/defuse-the-bomb/
You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n
and a key k.

To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.

If k > 0, replace the ith number with the sum of the next k numbers.
If k < 0, replace the ith number with the sum of the previous k numbers.
If k == 0, replace the ith number with 0.
As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
 */

public class DefuseTheBomb {
    /*
    Initially thought about using a queue and pop off the elements and add them back to the end of the queue to make it a circular
    array. That wouldn't work because the queue needs to be recreated at every i-th element. The difficult part of this problem
    for me was keeping track of where the pointer is once it reaches the end of the array when k is greater than 0 or when
    pointer reaches beginning of array when k is less than 0.
     */
    public int[] decrypt(int[] code, int k) {
        int[] arr = new int[code.length];

        if (k > 0) {
            for (int i = 0; i < arr.length; i++) {
                int sum = 0;
                int j = i;
                int n = k;
                while (n > 0) {
                    if (j + 1 < arr.length) {
                        sum += code[j + 1];
                        j++;
                        n--;
                    } else {
                        j = 0;
                        sum += code[j];
                        n--;
                    }
                }
                arr[i] = sum;
            }
        }

        if (k < 0) {
            for (int i = 0; i < arr.length; i++) {
                int sum = 0;
                int j = i;
                int n = k;
                while (n < 0) {
                    if (j - 1 >= 0) {
                        sum += code[j - 1];
                        j--;
                        n++;
                    } else {
                        j = arr.length - 1;
                        sum += code[j];
                        n++;
                    }
                }
                arr[i] = sum;
            }
        }

        return arr;
    }
}
