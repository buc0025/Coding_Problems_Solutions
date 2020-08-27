package BInaryTrees;
/*
https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
You are given a pointer to the root of a binary tree. You need to print the level order traversal of this tree.
In level order traversal, we visit the nodes level by level from left to right. You only have to complete the function
 */

public class LevelOrderTraversal {

    public static void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
    }
}
