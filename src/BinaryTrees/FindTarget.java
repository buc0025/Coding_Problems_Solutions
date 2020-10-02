package BinaryTrees;
/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such
that their sum is equal to the given target.
 */

public class FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        // Creating a list with all the nodes
        List<Integer> nodes = new ArrayList<>();
        inOrder(root, nodes);
        int front = 0;
        int end = nodes.size() - 1;

        // Checking to see if sum of front and back pointers equal target value
        while (front < end) {
            int sum = nodes.get(front) + nodes.get(end);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                front++;
            } else {
                end--;
            }
        }
        return false;
    }

    public void inOrder(TreeNode root, List list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
