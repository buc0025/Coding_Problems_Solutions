package arrays;
/*
https://leetcode.com/problems/assign-cookies/
Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j
has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to
maximize the number of your content children and output the maximum number.
 */

public class FindContentChildren {

    /* Much faster solution than original. The outer loop keeps track of all the possible cookie sizes. Both arrays are reversed
    so that we start from the largest sizes first and work our way down. I used an index to keep track of the visited elements in
    array g so that I don't have to revisit them when I go to the next iteration in the for loop.
    */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int index = g.length - 1;
        for (int i = s.length - 1; i >= 0; i--) {

            while (index >= 0) {
                if (s[i] >= g[index]) {
                    count++;
                    index--;
                    break;
                }
                index--;
            }
        }

        return count;
    }

    // First solution but really slow
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int index = g.length;
        for (int i = s.length - 1; i >= 0; i--) {
            for (int j = g.length - 1; j >= 0; j--) {
                if (s[i] >= g[j] && index > j) {
                    count++;
                    index = j;
                    break;
                }
            }
        }

        return count;
    }
}
