package arrays;
/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific
target number.

Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1]
<= numbers.length.

You may assume that each input would have exactly one solution and you may not use the same element twice.
 */

public class TwoSumII {

    /*
    I thought of using a set to keep track of elements in the array that I've already visited in my first solution. The first
    solution uses two loops but I thought I could do better by just using one loop and using a list to find the index of the
    element I'm looking for. Using indexOf() slowed it down significantly even though it only uses one loop.

    Top solution uses 2 pointers, one for the beginning of the array and another for the end. Since the array is already sorted,
    they compare the sum of the 2 pointers to the target. If it's bigger than the target then they decrement the end pointer, and
    vice versa if it's smaller until they equal to the target.
     */

    public int[] twoSum(int[] numbers, int target) {
        int diff = 0;
        int firstIndex = 1;
        int secondIndex = 1;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (list.contains(target - numbers[i])) {
                secondIndex += i;
                diff = target - numbers[i];
                firstIndex += list.indexOf(diff);
                break;
            } else {
                list.add(numbers[i]);
            }
        }

        return new int[] {firstIndex, secondIndex};
    }

    public int[] twoSum(int[] numbers, int target) {
        int diff = 0;
        int firstIndex = 1;
        int secondIndex = 1;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(target - numbers[i])) {
                secondIndex += i;
                diff = target - numbers[i];
                break;
            }
            set.add(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == diff && secondIndex != i + 1) {
                firstIndex += i;
                break;
            }
        }

        return new int[] {firstIndex, secondIndex};
    }
}
