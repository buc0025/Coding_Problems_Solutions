package BinaryTrees;
/*
https://leetcode.com/problems/leaf-similar-trees/
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Lists only return leaves
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1 = isLeaf(root1, list1);
        list2 = isLeaf(root2, list2);

        if (list1.size() != list2.size()) {
            return false;
        }

        int index = 0;

        // Comparing leaves of both trees
        for (int l : list1) {
            if (list2.get(index) != l) {
                return false;
            }
            index++;
        }

        return true;
    }

    public List<Integer> isLeaf(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
        }

        isLeaf(root.left, list);
        isLeaf(root.right, list);

        return list;
    }

    //*********More efficient solution*************
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Creating a list for the leaves of both trees to compare in return statement;
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();

        sameLeaves(root1, tree1);
        sameLeaves(root2, tree2);

        return tree1.equals(tree2);
    }

    public List sameLeaves(TreeNode root, List list) {
        if (root == null) {
            return null;
        }
        // Adding to the list if value is a leaf
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }

        sameLeaves(root.left, list);
        sameLeaves(root.right, list);

        return list;
    }

    //*********Original solution*************
    String leftTree = "";
    String rightTree = "";
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return leftRoot(root1).equals(rightRoot(root2));
    }
    // method used to determine string value of left tree's leaves
    public String leftRoot(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            leftTree += String.valueOf(root.val) + " ";
        }

        leftRoot(root.left);
        leftRoot(root.right);

        return leftTree;
    }
    // method used to determine string value of right tree's leaves
    public String rightRoot(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            rightTree += String.valueOf(root.val) + " ";
        }

        rightRoot(root.left);
        rightRoot(root.right);

        return rightTree;
    }
}
