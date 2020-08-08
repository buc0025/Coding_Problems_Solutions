package BInaryTrees;
/*
https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
Complete the preOrder function in your editor below, which has  parameter: a pointer to the root of a binary tree.
It must print the values in the tree's preorder traversal as a single line of space-separated values.
 */

public class PreorderTraverse {

    public static void preOrder(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");

        preOrder(root.left);
        preOrder(root.right);

    }
}
