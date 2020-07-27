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
