package BinaryHeaps;
/*
https://www.hackerrank.com/challenges/qheap1/problem
This question is designed to help you get a better understanding of basic heap operations.
You will be given queries of  types:

" " - Add an element  to the heap.
" " - Delete the element  from the heap.
"" - Print the minimum of all the elements in the heap.
NOTE: It is guaranteed that the element to be deleted will be there in the heap. Also, at any instant, only distinct elements will be in the heap.
 */

public class HeapOperations {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);

        int numOfQueries = input.nextInt();

        Queue<Integer> queue = new PriorityQueue<>(numOfQueries);

        while (numOfQueries > 0) {

            int action = input.nextInt();

            if (action == 1) {
                int numAdded = input.nextInt();
                queue.add(numAdded);

            } else if (action == 2) {
                int remove_Element = input.nextInt();
                queue.remove(remove_Element);

            } else if (action == 3) {
                System.out.println(queue.peek());
            }

            numOfQueries--;
        }
    }
}
