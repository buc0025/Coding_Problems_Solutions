package arrays;
/*
https://leetcode.com/problems/fair-candy-swap/
Alice and Bob have candy bars of different sizes: aliceSizes[i] is the size of the i-th bar of candy that Alice has, and
bobSizes[j] is the size of the j-th bar of candy that Bob has.

Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total
amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)

Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the
candy bar that Bob must exchange.

If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 */

public class FairCandySwap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        int bobSum = 0;

        Set<Integer> bobSet = new HashSet<>();

        for (int a : aliceSizes) {
            aliceSum += a;
        }

        for (int b : bobSizes) {
            bobSum += b;
            bobSet.add(b);
        }

        int split = (aliceSum + bobSum) / 2;

        int aNum = 0;
        int bNum = 0;

        for (int a : aliceSizes) {
            int num = split - (aliceSum - a);
            if (bobSet.contains(num)) {
                aNum = a;
                bNum = num;
                break;
            }
        }

        return new int[] {aNum, bNum};
    }
}
