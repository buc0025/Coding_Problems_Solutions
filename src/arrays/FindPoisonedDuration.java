package arrays;
/*
https://leetcode.com/problems/teemo-attacking/
Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo attacks Ashe, Ashe gets poisoned for a exactly duration
seconds. More formally, an attack at second t will mean Ashe is poisoned during the inclusive time interval [t, t + duration - 1].
If Teemo attacks again before the poison effect ends, the timer for it is reset, and the poison effect will end duration seconds
after the new attack.

You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes that Teemo attacks Ashe at second
timeSeries[i], and an integer duration.

Return the total number of seconds that Ashe is poisoned.

 */

public class FindPoisonedDuration {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int dur = duration;

        if (duration > 0) {
            duration -= 1;
        }

        int num = timeSeries[0] + duration;
        int count = dur;

        for (int i = 1; i < timeSeries.length; i++) {
            int next = timeSeries[i] + duration;
            if (num >= timeSeries[i]) {
                count += next - num;
            } else {
                count += dur;
            }
            num = next;
        }

        return count;
    }

    //Time limit exceeded
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < timeSeries.length; i++) {
            int start = timeSeries[i];
            int end = start + duration;
            while (start < end) {
                set.add(start);
                start++;
            }
        }

        return set.size();
    }
}
