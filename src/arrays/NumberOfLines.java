package arrays;
/*
https://leetcode.com/problems/number-of-lines-to-write-string/

You are given a string s of lowercase English letters and an array widths denoting how many pixels wide each lowercase English
letter is. Specifically, widths[0] is the width of 'a', widths[1] is the width of 'b', and so on.

You are trying to write s across several lines, where each line is no longer than 100 pixels. Starting at the beginning of s,
write as many letters on the first line such that the total width does not exceed 100 pixels. Then, from where you stopped in s,
continue writing as many letters as you can on the second line. Continue this process until you have written all of s.

Return an array result of length 2 where:

result[0] is the total number of lines.
result[1] is the width of the last line in pixels.
 */

public class NumberOfLines {

    // 8/3/2022 solution
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int pixel = widths[s.charAt(i) - 'a'];
            max += pixel;

            if (max > 100) {
                max = pixel;
                lines++;
            }
        }

        return new int[] {lines, max};
    }
}
