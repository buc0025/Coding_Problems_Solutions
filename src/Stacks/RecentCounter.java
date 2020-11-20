package Stacks;
import java.util.*;
/*
https://leetcode.com/problems/number-of-recent-calls/
Write a class RecentCounter to count recent requests.

It has only one method: ping(int t), where t represents some time in milliseconds.

Return the number of pings that have been made from 3000 milliseconds ago until now.

Any ping with time in [t - 3000, t] will count, including the current ping.

It is guaranteed that every call to ping uses a strictly larger value of t than before.
 */


public class RecentCounter {

    // Question took a while to understand and runtime is TERRIBLE
    class RecentCounter {
        List<Integer> list;

        public RecentCounter() {
            list = new ArrayList<>();
        }

        public int ping(int t) {
            list.add(t);
            int startRange = t - 3000;
            int inRange = 0;

            for (int l : list) {
                if (l >= startRange) {
                    inRange++;
                }
            }
            return inRange;
        }
    }

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (t - 3000 > queue.peek()) {
            queue.poll();
        }
        return queue.size();
    }
}
