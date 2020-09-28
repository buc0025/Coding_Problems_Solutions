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

        // Combining the 2 lists after inorder traversal of the 2 trees
        return combineLists(inOrder(root1, tree1), inOrder(root2, tree2));
    }
    // Method returns a sorted list of the combined lists from the two different trees
    public List combineLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> combined = new ArrayList<>();

        int list1Index = 0; // keeps track of the index in list1;
        int list2Index = 0; // keeps track of the index in list2;

        if (list1 == null && list2 != null) {
            return list2;
        }

        if (list2 == null && list1 != null) {
            return list1;
        }
        // Adds smaller item between two lists to new list
        while (list1Index < list1.size() && list2Index < list2.size()) {
            if (list1.get(list1Index) < list2.get(list2Index)) {
                combined.add(list1.get(list1Index));
                list1Index++;
            } else {
                combined.add(list2.get(list2Index));
                list2Index++;
            }
        }
        // Adds the remaining items in list1 if there's no more items left in list2
        while (list1Index < list1.size()) {
            combined.add(list1.get(list1Index));
            list1Index++;
        }
        // Adds the remaining items in list2 if there's no more items left in list1
        while (list2Index < list2.size()) {
            combined.add(list2.get(list2Index));
            list2Index++;
        }
        return combined;
    }
    // Method uses inorder traversal to get sort list from BST
    public List inOrder(TreeNode root, List list) {
        if (root == null) {
            return null;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

        return list;
    }
}
