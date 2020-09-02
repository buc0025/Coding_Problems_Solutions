package BInaryTrees;
/*
https://leetcode.com/problems/deepest-leaves-sum/
Given a binary tree, return the sum of values of its deepest leaves.
 */

public class DeepestLeavesSum {

    public static class PositionNode {
        TreeNode node;
        int level;

        public PositionNode(final TreeNode node, final int level) {
            this.node = node;
            this.level = level;
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = treeDepth(root);
        int level = 0;
        int sum = 0;

        final Queue<PositionNode> q = new LinkedList<>();
        q.add(new PositionNode(root, 1));

        while (!q.isEmpty()) {
            final PositionNode pn = q.poll();
            level = pn.level;

            if (level != depth) {

                if (pn.node.left != null) {
                    q.add(new PositionNode(pn.node.left, level + 1));
                }

                if (pn.node.right != null) {
                    q.add(new PositionNode(pn.node.right, level + 1));
                }
            }

            if (level == depth) {
                sum += pn.node.val;
            }
        }

        return sum;
    }

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
