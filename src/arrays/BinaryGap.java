package arrays;
/*
https://leetcode.com/problems/binary-gap/

Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n.
If there are no two adjacent 1's, return 0.

Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute
difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.
 */

public class BinaryGap {

    // 9/6/2022 unfinished solution
    public int binaryGap(int n) {
        int[] binary = new int[10];
        int id = 0;

        while (n > 0) {
            binary[id++] = n % 2;
            n = n / 2;
        }

        int ans = 0;
        int place = 1;

        for (int i = id - 1; i >= 0; i--) {
            ans += (binary[i] * 10 * place);
            place++;
        }

        return ans;
    }
}
