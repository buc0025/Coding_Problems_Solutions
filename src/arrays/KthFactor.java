package arrays;
/*
Given two positive integers n and k.
A factor of an integer n is defined as an integer i where n % i == 0.
Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has
less than k factors.
 */

public class KthFactor {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }

        if (k > list.size()) {
            return -1;
        } else {
            return list.get(k - 1);
        }
    }
}
