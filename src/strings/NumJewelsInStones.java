package strings;
/*
https://leetcode.com/problems/jewels-and-stones/

You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each
character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */

public class NumJewelsInStones {

    // 8/1/2022 solution
    public int numJewelsInStones(String jewels, String stones) {
        Set<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.substring(i, i + 1));
        }

        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.substring(i, i + 1))) {
                count++;
            }
        }

        return count;
    }
}
