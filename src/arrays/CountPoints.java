package arrays;
/*
https://leetcode.com/problems/rings-and-rods/

There are n rings and each ring is either red, green, or blue. The rings are distributed across ten rods labeled from 0 to 9.

You are given a string rings of length 2n that describes the n rings that are placed onto the rods. Every two characters in rings
forms a color-position pair that is used to describe each ring where:

The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').
For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3, a green ring placed onto the rod labeled
2, and a blue ring placed onto the rod labeled 1.

Return the number of rods that have all three colors of rings on them.
 */

public class CountPoints {

    // 4/3/2022 solution
    public int countPoints(String rings) {
        Map<Integer, String> map = new HashMap<>();
        int rodsWithRings = 0;

        for (int i = 0; i < rings.length(); i+=2) {

            int ring = Integer.valueOf(rings.substring(i + 1, i + 2));
            String color = rings.substring(i, i + 1);

            if (map.containsKey(ring)) {
                String colors = map.get(ring) + color;
                map.put(ring, colors);
            } else {
                map.put(ring, color);
            }
        }

        for (int color : map.keySet()) {
            String colors = map.get(color);
            if (colors.contains("B") && colors.contains("R") && colors.contains("G")) {
                rodsWithRings++;
            }
        }

        return rodsWithRings;
    }

    // 4/2/2022 unfinished solution
    public int countPoints(String rings) {
        int[] arr = new int[10];

        for (int i = 1; i < rings.length(); i+=2) {
            int n = Integer.valueOf(rings.substring(i, i + 1));
            arr[n]++;
        }

        boolean over3 = false;

        for (int a : arr) {
            if (a >= 3) {
                over3 = true;
            }
        }

        if (!over3) {
            return 0;
        }
    }
}
