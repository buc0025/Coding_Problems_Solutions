package arrays;
/*
https://leetcode.com/problems/last-stone-weight/
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.
The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        List<Integer> list = new ArrayList<>();
        for (int s : stones) {
            list.add(s);
        }

        while (list.size() >= 2) {
            int rock = list.get(list.size() - 1) - list.get(list.size() - 2);
            if (rock == 0) {
                list.remove(list.size()-1);
                list.remove(list.size()-1);
            } else {
                list.remove(list.size()-1);
                list.remove(list.size()-1);

                if (list.size() > 0 && rock > list.get(list.size()-1)) {
                    list.add(rock);
                } else if (list.size() == 0) {
                    list.add(rock);
                    break;
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        if (rock <= list.get(i)) {
                            list.add(i, rock);
                            break;
                        }
                    }
                }
            }
        }

        if (list.size() == 0) {
            return 0;
        } else {
            return list.get(0);
        }
    }
}
