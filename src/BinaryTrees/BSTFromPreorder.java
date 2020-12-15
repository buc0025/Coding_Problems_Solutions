package BinaryTrees;
/*
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and
any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first,
then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 */

public class BSTFromPreorder {

    // Incorrect solution although it does return a BST
    public TreeNode bstFromPreorder(int[] preorder) {
        Arrays.sort(preorder);

        return arrToBST(preorder, 0, preorder.length-1);
    }

    public TreeNode arrToBST(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = arrToBST(arr, left, mid - 1);
        root.right = arrToBST(arr, mid + 1, right);

        return root;
    }
}
