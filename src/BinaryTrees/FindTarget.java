package BinaryTrees;
/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such
that their sum is equal to the given target.
 */

public class FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        list = helper(root, list);

        for (int l : list) {
            // This logic helps with cases like [1,2,3] and k = 6
            if (list.contains(k - l) && l != k - l) {
                return true;
            }
        }

        return false;
    }

    public List<Integer> helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);

        return list;
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // BST cannot have duplicates so I'm using a set to hold all nodes
        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            // Populating set with all nodes
            set.add(top.val);
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
            // Checking to see if sum of 2 elements in BST is equal to
            // target and making sure it's not counting itself twice
            // e.g. (6 - 3 = 3)
            if (set.contains(k - top.val) && k - top.val != top.val) {
                return true;
            }
        }
        return false;
    }

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
