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
        if (n == 1) {
            return 1;
        }

        int[] arr = new int[n + 1];

        //Increment arr[i] to indicate frequency of potential judge
        for (int i = 0; i < trust.length; i++) {
            arr[trust[i][1]]++;
        }

        //If judge appears as towns person then they are not the judge
        for (int i = 0; i < trust.length; i++) {
            if (arr[trust[i][0]] > 0) {
                arr[trust[i][0]] = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }

        //Sets keep track of the townspeople and potential judges
        Set<Integer> judge = new HashSet<>();
        Set<Integer> town = new HashSet<>();

        for (int i = 0; i < trust.length; i++) {
            judge.add(trust[i][1]);
            town.add(trust[i][0]);
        }

        int answer = -1;

        //If the judges don't appear as a towns person then they replace answer
        for (int j : judge) {
            if (!town.contains(j)) {
                answer = j;
                break; // There can only be 1 judge so we break out early if we find one
            }
        }

        int count = 0; // Keeps track of how many times the potential judge has been voted


        for (int i = 0; i < trust.length; i++) {
            if (trust[i][1] == answer) {
                count++;
            }
        }
        // If count equals to all the townspeople excluding the judge then we return the judge
        if (count == n - 1) {
            return answer;
        }

        return -1;
    }
}
