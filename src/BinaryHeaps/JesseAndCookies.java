package BinaryHeaps;
/*
https://www.hackerrank.com/challenges/jesse-and-cookies/problem
Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value K. To do this, Jesse repeatedly
mixes two cookies with the least sweetness. He creates a special combined cookie with:

sweetness = (1 * Least sweet cookie + 2 * 2nd least sweet cookie).

He repeats this procedure until all the cookies in his collection have a sweetness >= K.
You are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness >= K.
Print -1 if this isn't possible.
 */

public class JesseAndCookies {

    static int cookies(int k, int[] A) {

        Queue<Integer> queue = new PriorityQueue<>();
        int n = 0;

        for (int a : A) {
            queue.add(a);
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (queue.peek() < k) {
                int cookie = queue.poll() + queue.poll() * 2;
                queue.add(cookie);
                n++;
            }
        }

        if (queue.peek() < k) {
            return -1;
        } else {
            return n;
        }

    }

}
