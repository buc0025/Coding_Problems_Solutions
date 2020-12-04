package BinaryTrees;
/*
https://leetcode.com/problems/deepest-leaves-sum/
Given a binary tree, return the sum of values of its deepest leaves.
 */

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        int maxLevel = maxLevel(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int sum = 0;

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top != null) {
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
            // Only add the values at the last level
            if (maxLevel == 1) {
                if (top != null) {
                    sum += top.val;
                }
            }

            // Keeps track of each level
            if (queue.peek() == null) {
                queue.add(null);
                maxLevel--;
            }

            if (top == null && queue.peek() == null) {
                break;
            }
        }
        return sum;
    }

    public int maxLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxLevel(root.left) + 1;
        int rightMax = maxLevel(root.right) + 1;

        return Math.max(leftMax, rightMax);
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // Let's me know to change level
        int sum = 0;

        // The queue will never be empty since null is being added each
        // time queue.poll() == null. Once the queue size gets below 2,
        // the queue only contains null.
        while (queue.size() >= 2) {
            TreeNode top = queue.poll();
            if (top != null) {
                sum += top.val;
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }

            if (top == null) {
                queue.add(null); // null is added to distinguish levels
                sum = 0; // Sum resets to 0 at each new level
            }
        }
        return sum;
    }

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
