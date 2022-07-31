package arrays;
/*
https://leetcode.com/problems/summary-ranges/

You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is
covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 */

public class SummaryRanges {

    // 7/29/2022 unfinished solution
    // testing token
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];
        boolean consec = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == start + 1) {
                end = nums[i];
                consec = true;
            } else {
                consec = false;
                if (start == end) {
                    list.add(start + "");
                } else {
                    list.add(start + "->" + end);
                }
                start = nums[i];
            }
        }

        return list;
    }
}
