package BinaryTrees;
/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 */

public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // The first null will let me know I've reach the end of the level

        long sum = 0;
        int num = 0;

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();

            if (top != null) {
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }

                sum += top.val;
                num++;
                // null will let me know when I reached the end of a level and add the average to list
                if (queue.peek() == null) {
                    queue.add(null);
                    list.add((double) sum / num);
                    sum = 0;
                    num = 0;
                }
            }
            // Two nulls in a row means there are no more nodes left
            if (top == null && queue.peek() == null) {
                break;
            }
        }

        return list;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);  // null is added right after first value to represent the end of the level
        double sum = 0;  // keeps track of running sum for each level
        double div = 0;  // keeps track of number of nodes in each level

        while(!queue.isEmpty()) {
            TreeNode top = queue.poll();
            // don't want to add null value to running sum
            if (top != null) {
                sum += (double)top.val;
                div++;
            }
            // having 2 null values in a roll means there are no more levels
            if (top == null && queue.peek() == null) {
                break;
            }

            if (top != null && top.left != null) {
                queue.offer(top.left);
            }

            if (top != null && top.right != null) {
                queue.offer(top.right);
            }
            // statement helps find the end of a level and goes to next level while adding the
            // average to the list and resetting sum and number of nodes in each level
            if (queue.peek() == null) {
                queue.poll();
                list.add(sum / div);
                sum = 0;
                div = 0;
                queue.offer(null);
            }
        }
        return list;
    }
}
