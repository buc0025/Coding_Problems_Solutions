package BinaryHeaps;
/*
https://www.hackerrank.com/challenges/java-comparator/problem
Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array.
The Player class is provided for you in your editor. It has 2 fields: a name String and a score integer.
Given an array of n Player objects, write a comparator that sorts them in order of decreasing score; if 2 or more players
have the same score, sort those players alphabetically by name. To do this, you must create a Checker class that
implements the Comparator interface, then write an int compare(Player a, Player b) method implementing the
Comparator.compare(T o1, T o2) method.
 */

public class JavaComparator {
    class Checker implements Comparator<Player> {

        public int compare(Player p1, Player p2) {
            if (p1.score == p2.score) {
                if (p1.name.compareTo(p2.name) < 0) {
                    return -1;
                } else {
                    return 1;
                }
            }

            if (p1.score > p2.score) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
