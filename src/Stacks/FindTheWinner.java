package Stacks;
/*
https://leetcode.com/problems/find-the-winner-of-the-circular-game/
There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order.
More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the
nth friend brings you to the 1st friend.

The rules of the game are as follows:

Start at the 1st friend.
Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and
may count some friends more than once.
The last friend you counted leaves the circle and loses the game.
If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the
friend who just lost and repeat.
Else, the last friend in the circle wins the game.
Given the number of friends, n, and an integer k, return the winner of the game.
 */

public class FindTheWinner {

    /*
    A queue acts like a circle if the elements in the front keeps getting added to the back. I thought about using a list but would
    have to deal with the case of reaching the end of the list. Every time the Kth element is visited, that element from the queue
    is removed else the queue will keep adding the elements to the end.
     */
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            int delete = k - 1;
            while (delete > 0) {
                queue.add(queue.poll());
                delete--;
            }
            queue.poll();
        }

        return queue.peek();
    }
}
