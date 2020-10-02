package BinaryTrees;
/*
https://leetcode.com/problems/increasing-order-search-tree/
Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the
tree, and every node has no left child and only 1 right child.
 */

public class IncreasingOrderBST {
    public TreeNode increasingBST(TreeNode root) {
        // Creating a list of in-order tree values
        List<Integer> nodes = new ArrayList<>();
        inOrder(root, nodes);
        // Assigning first element from list to root
        root = new TreeNode(nodes.get(0));
        // Remove element from beginning of list once it's assigned
        nodes.remove(0);

        // Assign rest of the list to only the right child of each node
        while (!nodes.isEmpty()) {
            root.right = new TreeNode(nodes.get(0));
            nodes.remove(0);
        }

        return root;
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
