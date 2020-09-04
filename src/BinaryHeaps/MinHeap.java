package BinaryHeaps;
/*
Design an algorithm that can check whether a heap (with array representation) is a valid min heap or not.
Valid min heap is when the parent node is smaller than the children.
 */

public class MinHeap {

    public static String isMinHeap(int[] arr) {

        if (arr.length == 1) {
            return "is a min heap";
        }

        //checks if last parent with children has only 1 child
        if (arr.length % 2 == 0) {
            for (int i = 0; i <= (arr.length - 2) / 2; i++) {
                if (arr[i] > arr[2 * i + 1]) {
                    return "not a min heap";
                }
            }
            return "is a min heap";
        }

        //checks complete binary heap if last parent with children has both children
        for (int i = 0; i <= (arr.length - 2) / 2; i++) {
            if (arr[i] > arr[2 * i + 1] || arr[i] > arr[2 * i + 2]) {
                return "not a min heap";
            }
        }
        return "is a min heap";

    }
}
