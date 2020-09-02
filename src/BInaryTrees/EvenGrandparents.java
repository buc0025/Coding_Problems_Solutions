package BInaryTrees;
/*
https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is
the parent of its parent, if it exists.

If there are no nodes with an even-valued grandparent, return 0.
 */
public class EvenGrandparents {

    public int sumEvenGrandparent(TreeNode root) {
        return sumHelper(root, 0);
    }

    public int sumHelper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int temp = 0;

        if (root.val % 2 == 0) {

            if (root.left != null) {

                if (root.left.left != null) {
                    temp += root.left.left.val;
                }

                if (root.left.right != null) {
                    temp += root.left.right.val;
                }
            }

            if (root.right != null) {

                if (root.right.left != null) {
                    temp += root.right.left.val;
                }

                if (root.right.right != null) {
                    temp += root.right.right.val;
                }
            }
        }

        return temp + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}
