package BInarySearchTrees;
/*
https://www.hackerrank.com/challenges/tree-inorder-traversal/problem
Complete the inOrder function in your editor below, which has  parameter: a pointer to the root of a binary tree.
It must print the values in the tree's inorder traversal as a single line of space-separated values.
 */

public class InorderTraverse {

    public static void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }
}
