package arrays;
/*
https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other, otherwise
return False.
 */

public class KLengthApart {

    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) {
            return true;
        }

        int index = 0 - (k + 1); // -1
        int index2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                index2 = i;
                if (index2 - index <= k) {
                    return false;
                } else {
                    index = i;
                }
            }
        }

        return true;
    }

    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) {
            return true;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                list.add(i);
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) <= k) {
                return false;
            }
        }
        return true;
    }
}
