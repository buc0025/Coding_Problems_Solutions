package Stacks;
import java.util.*;

/*
https://leetcode.com/problems/build-an-array-with-stack-operations/
Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

Build the target array using the following operations:

Push: Read a new element from the beginning list, and push it in the array.
Pop: delete the last element of the array.
If the target array is already built, stop reading more elements.
You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.

Return the operations to build the target array.

You are guaranteed that the answer is unique.
 */

public class BuildArray {

    public List<String> buildArray(int[] target, int n) {
        // Target array will become a set to be used to compare elements from new array later on
        Set<Integer> set = new HashSet<>();
        for (int t : target) {
            set.add(t);
        }

        // Creating array that contains elements 1 to the last element of target array
        int[] arr = new int[target[target.length-1]];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        List<String> list = new ArrayList<>();
        // Populating list with "Push" for elements that match up in new array and given array
        // while populating list with "Push, Pop" if target array is missing elements from new array
        for (int a : arr) {
            if (set.contains(a)) {
                list.add("Push");
            } else {
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        int index = 0;

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        for (int i = 0; i < nums.size(); i++) {
            if (target[index] != nums.get(i)) {
                list.add("Push");
                list.add("Pop");
            }
            if (target[index] == nums.get(i)) {
                list.add("Push");
                index++;
            }
            if (index > target.length-1) {
                break;
            }
        }

        return list;
    }
}
