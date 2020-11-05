package BinaryTrees;
/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
Given a binary tree, flatten it to a linked list in-place.
 */

public class FlattenTree {

    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            // Thought I was adding nodes to right subtree only
            if (top.left != null) {
                root.right = top.left;
                queue.add(top.left);
            }
            if (top.right != null) {
                root.right = top.right;
                queue.add(top.right);
            }
        }
    }
}
