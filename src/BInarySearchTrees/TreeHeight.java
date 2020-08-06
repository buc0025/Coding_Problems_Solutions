package BInarySearchTrees;
/*
https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

 */

public class TreeHeight {
    public static int height(Node root) {
        // Write your code here.

        if (root == null) {
            return -1;
        }

        int leftSide = height(root.left);
        int rightSide = height(root.right);

        return Math.max(leftSide, rightSide) +1;
    }
}
