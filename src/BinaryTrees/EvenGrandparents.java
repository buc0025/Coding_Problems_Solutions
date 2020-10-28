package BinaryTrees;
/*
https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is
the parent of its parent, if it exists.

If there are no nodes with an even-valued grandparent, return 0.
 */
public class EvenGrandparents {

    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.left != null) {
                queue.add(top.left);
                // Checking to see if there's a grandchild in left sub tree
                // if node is even-valued
                if (top.left.left != null && top.val % 2 == 0) {
                    sum += top.left.left.val;
                }
                if (top.left.right != null && top.val % 2 == 0) {
                    sum += top.left.right.val;
                }
            }
            if (top.right != null) {
                queue.add(top.right);
                // Checking to see if there's a grandchild in right sub tree
                // if node is even-valued
                if (top.right.left != null && top.val % 2 == 0) {
                    sum += top.right.left.val;
                }
                if (top.right.right != null && top.val % 2 == 0) {
                    sum += top.right.right.val;
                }
            }
        }
        return sum;
    }

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
