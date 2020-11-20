package BinaryTrees;
/*
https://leetcode.com/problems/search-in-a-binary-search-tree/
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's
value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 */

public class SearchTree {

    // Such an easy recursive answer, but I just couldn't come up with it. I resorted to DFS, but I really need to work
    // on using recursion for this problem.
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.val == val) {
                return top;
            }
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
        }

        return null;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        }

        return  searchBST(root.right, val) ;

    }
}
