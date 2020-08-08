package BInaryTrees;
/*
https://www.hackerrank.com/challenges/tree-postorder-traversal/problem
Complete the postOrder function in your editor below, which has  parameter: a pointer to the root of a binary tree.
It must print the values in the tree's postorder traversal as a single line of space-separated values.

 */

public class PostorderTraverse {
    public static void postOrder(Node root) {

        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }
}
