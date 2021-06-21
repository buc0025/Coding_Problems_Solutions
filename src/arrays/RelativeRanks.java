package arrays;
/*
https://leetcode.com/problems/relative-ranks/
You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores
are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the
2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.
 */

public class RelativeRanks {

    // After the scores are sorted, a map is used to hold the points as keys and the placing as values.
    public String[] findRelativeRanks(int[] score) {
        int[] sorted = score.clone();
        Arrays.sort(sorted);
        String[] result = new String[score.length];
        Map<Integer, Integer> map = new HashMap<>();

        int place = 1;
        for (int i = sorted.length - 1; i >= 0; i--) {
            map.put(sorted[i], place);
            place++;
        }

        for (int i = 0; i < result.length; i++) {
            if (map.get(score[i]) == 1) {
                result[i] = "Gold Medal";
            } else if (map.get(score[i]) == 2) {
                result[i] = "Silver Medal";
            } else if (map.get(score[i]) == 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = map.get(score[i]) + "";
            }
        }

        return result;
    }
}
