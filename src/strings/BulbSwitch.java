package strings;
/*
https://leetcode.com/problems/bulb-switcher-iv/
There is a room with n bulbs, numbered from 0 to n-1, arranged in a row from left to right. Initially all the bulbs are
turned off. Your task is to obtain the configuration represented by target where target[i] is '1' if the i-th bulb is
turned on and is '0' if it is turned off. You have a switch to flip the state of the bulb, a flip operation is defined
as follows:

Choose any bulb (index i) of your current configuration.
Flip each bulb from index i to n-1.

When any bulb is flipped it means that if it is 0 it changes to 1 and if it is 1 it changes to 0.
Return the minimum number of flips required to form target.
 */

public class BulbSwitch {

    public int minFlips(String target) {
        int count = 0;
        char flip = '0';

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != flip) {
                count++;
            }
            // changes the current status of the switch that will in turn help compare and count the next switch
            flip = count % 2 == 1 ? '1' : '0';
        }

        return count;
    }

    public int minFlips(String target) {
        // Count will always be at least 1 if target contains a "1"
        int count = 1;
        int start = target.indexOf('1');

        // No changes if target doesn't contain "1"
        if (start < 0) {
            return 0;
        }

        // Any time a cluster is broken up, count will be incremented
        // Start point is at the index of the first "1" because that's the first change
        for (int i = start; i < target.length()-1; i++) {
            if (target.charAt(i + 1) != target.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public int minFlips(String target) {
        int count = 0;

        // If the first char is 1, switch has be turn on at least once and count will start at 1
        if (target.indexOf("1") == 0) {
            count = 1;
        }

        // Noticed that clusters revealed the number of switches. Any time a switch doesn't match
        // with the switch next to it, it breaks the cluster
        for (int i = 0; i < target.length() - 1; i++) {
            if (target.charAt(i) != target.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}
