package BInaryTrees;
/*
https://leetcode.com/problems/univalued-binary-tree/
A binary tree is univalued if every node in the tree has the same value.
Return true if and only if the given tree is univalued.
 */

public class UnivaluedBST {

    public boolean isUnivalTree(TreeNode root) {
        int num = numNodes(root);
        int sum = sumNodes(root);

        if (sum % num != 0) {
            return false;
        } else {
            return root.val == (sum / num);
        }
    }

    public int numNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int countL = numNodes(root.left);
        int countR = numNodes(root.right);

        return countL + countR + 1;
    }

    public int sumNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int countL = sumNodes(root.left);
        int countR = sumNodes(root.right);

        return countL + countR + root.val;
    }
}
