package Maps_Sets_Tables;
/*
https://www.hackerrank.com/challenges/java-hashset/problem
You are given n pairs of strings. Two pairs (a,b) and (c,d) are identical if a = c and b = d. That also implies (a,b)
is not same as (b,a). After taking each pair as input, you need to print number of unique pairs you currently have.
Complete the code in the editor to solve this problem.
 */

public class HashSet {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

//Write your code here
        String[] newPair = new String[t];

        for (int i = 0; i < t; i++) {
            newPair[i] = pair_left[i] + " " + pair_right[i];
        }

        HashSet<String> set = new HashSet<String>();

        for (String p : newPair) {
            set.add(p);
            System.out.println(set.size());
        }
    }
}
