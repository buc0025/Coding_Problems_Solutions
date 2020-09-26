package BinaryTrees;
/*
https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.
 */

public class AllElementsBSTs {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();

        return combineLists(allNodes(root1, tree1), allNodes(root2, tree2));
    }
    // Method returns a sorted list of the combined lists from the two different trees
    public List combineLists(List list1, List list2) {
        List<Integer> combined = new ArrayList<>();

        int list1Index = 0; // keeps track of the index in list1;
        int list2Index = 0; // keeps track of the index in list2;
        // Adds smaller item between two lists to new list
        while (list1Index < list1.size() && list2Index < list2.size()) {
            if ((int)list1.get(list1Index) < (int)list2.get(list2Index)) {
                combined.add((int)list1.get(list1Index));
                list1Index++;
            } else {
                combined.add((int)list2.get(list2Index));
                list2Index++;
            }
        }
        // Adds the remaining items in list1 if there's no more items left in list2
        while (list1Index < list1.size()) {
            combined.add((int)list1.get(list1Index));
            list1Index++;
        }
        // Adds the remaining items in list2 if there's no more items left in list1
        while (list2Index < list2.size()) {
            combined.add((int)list2.get(list2Index));
            list2Index++;
        }
        return combined;
    }
    // Method uses inorder traversal to get sort list from BST
    public List allNodes(TreeNode root, List list) {
        if (root == null) {
            return null;
        }

        allNodes(root.left, list);
        list.add(root.val);

        allNodes(root.right, list);

        return list;
    }
}
