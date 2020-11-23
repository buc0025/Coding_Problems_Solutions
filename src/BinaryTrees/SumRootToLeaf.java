package BinaryTrees;
/*
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
You are given the root of a binary tree where each node has a value 0 or 1.  Each root-to-leaf path represents a binary number
starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in
binary, which is 13.
For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.
 */

public class SumRootToLeaf {

    // Incorrect attempt. I honestly didn't know how to go about this without turning the root to leaf into a String. If the
    // root to leaf was [1,0,0], I couldn't think of a way keep it as an int because of I added it it would've been 1.
    public int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        rootToLeaf(root, list, "");

        int sum = 0;

        // Goes through the list of String value binary numbers and adds them to the sum
        while (!list.isEmpty()) {
            sum += stringToInt(list.get(0));
            list.remove(0);
        }

        return sum;
    }

    // Idea of this method was to turn every root to leaf into a string and add it to a list
    public void rootToLeaf(TreeNode root, List<String> list, String res) {
        if (root == null) {
            res = "";
        }

        if (root.left == null && root.right == null) {
            list.add(res);
        } else {
            res += String.valueOf(root.val);
        }

        rootToLeaf(root.left, list, res);
        rootToLeaf(root.right, list, res);
    }

    // Turns strings in list into binary numbers and returns its decimal value
    public int stringToInt(String stringNum) {
        int num = Integer.valueOf(stringNum);
        int decValue = 0;
        int base = 1;
        int temp = num;

        while (temp > 0) {
            int end = temp % 10;
            temp = temp / 10;
            decValue += end * base;
            base = base * 2;
        }
        return decValue;
    }
}
