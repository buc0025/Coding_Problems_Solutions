package BinaryTrees;
/*
https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.
 */

public class AllElementsBSTs {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inOrder(root1, list1);
        inOrder(root2, list2);

        return combineLists(list1, list2);
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public List<Integer> combineLists(List<Integer> list1, List<Integer> list2) {
        int[] arr = new int[list1.size() + list2.size()];
        int index = 0;

        // Add list1 to array first and then list2
        for (int i = 0; i < arr.length; i++) {
            if (i >= list1.size()) {
                arr[i] = list2.get(index);
                index++;
            } else {
                arr[i] = list1.get(i);
            }
        }

        Arrays.sort(arr);

        List<Integer> combined = new ArrayList<>();

        for (int a : arr) {
            combined.add(a);
        }

        return combined;
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        return allElements(inOrder(root1, list1), inOrder(root2, list2));
    }

    public List<Integer> allElements(List<Integer> root1List, List<Integer> root2List) {
        List<Integer> combineAll = new ArrayList<>();

        if (root1List == null) {
            return root2List;
        }

        if (root2List == null) {
            return root1List;
        }
        // Adds smaller int from the two lists to new combineAll list
        // and removes smaller int from original list
        while (!root1List.isEmpty() && !root2List.isEmpty()) {
            if (root1List.get(0) < root2List.get(0)) {
                combineAll.add(root1List.get(0));
                root1List.remove(0);
            } else {
                combineAll.add(root2List.get(0));
                root2List.remove(0);
            }
        }
        // Adds remaining integers to combineAll list
        while (!root1List.isEmpty()) {
            combineAll.add(root1List.get(0));
            root1List.remove(0);
        }
        // Adds remaining integers to combineAll list
        while (!root2List.isEmpty()) {
            combineAll.add(root2List.get(0));
            root2List.remove(0);
        }
        return combineAll;
    }
    // Method returns sorted list from BST
    public List<Integer> inOrder(TreeNode root, List list) {
        if (root == null) {
            return null;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

        return list;
    }

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
