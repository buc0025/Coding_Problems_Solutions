package Stacks;
/*
https://edabit.com/challenge/GPAXxz5EPgSMby3fd

Write a function that returns true if every consecutive sequence of ones is followed by a consecutive sequence of zeroes of the same length.
 */

public class OnesAndZeroes {

    // Solution passes 9 out of 12 test cases
    public static boolean sameLength(String str) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                stack.push(1);
            } else if (stack.empty()) {
                return false;
            } else {
                stack.pop();
            }
        }

        return true;
    }
}
