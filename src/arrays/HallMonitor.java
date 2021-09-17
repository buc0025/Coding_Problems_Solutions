package arrays;
/*
https://edabit.com/challenge/p5PsoKc2z8QaYNjNG
A floor plan is arranged as follows:

Four rooms, which all lead into the hallway.
It's impossible to move between rooms without first going into the hallway.
Create a function which validates whether the path between rooms is possible. The hallway will be given as the letter "H".
 */

public class HallMonitor {

    public static boolean possiblePath(Object[] t) {
        Set<Object> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        for (int i = 1; i < t.length; i++) {
            if (set.contains(t[i]) && set.contains(t[i - 1])) {
                return false;
            }
        }

        return true;
    }
}
