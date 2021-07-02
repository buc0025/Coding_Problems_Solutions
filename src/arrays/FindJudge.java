package arrays;
/*
https://leetcode.com/problems/find-the-town-judge/
In a town, there are n people labelled from 1 to n.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */

public class FindJudge {

    public int findJudge(int n, int[][] trust) {
        Set<Integer> judge = new HashSet<>();
        Set<Integer> town = new HashSet<>();
        int count = 0;

        for (int i = 0; i < trust.length; i++) {
            judge.add(trust[i][1]);
            town.add(trust[i][0]);
        }

        List<Integer> list = new ArrayList<>();

        for (int j : judge) {
            if (!town.contains(j)) {
                list.add(j);
            }
        }

        if (list.size() > 0) {
            for (int i = 0; i < trust.length; i++) {
                if (trust[i][1] == list.get(0)) {
                    count++;
                }
            }
            if (count == town.size()) {
                return list.get(0);
            }
        }

        return -1;
    }
}
