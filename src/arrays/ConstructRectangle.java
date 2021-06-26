package arrays;
/*
https://leetcode.com/problems/construct-the-rectangle/
A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now
is to design a rectangular web page, whose length L and width W satisfy the following requirements:

The area of the rectangular web page you designed must equal to the given target area.
The width W should not be larger than the length L, which means L >= W.
The difference between length L and width W should be as small as possible.
Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.
 */

public class ConstructRectangle {

    /*
    Top solution only uses one variable to hold the square root of area. They enter a while loop if area % var != 0 and decrement
    var. This will get the smallest difference possible between length and width.
     */
    public int[] constructRectangle(int area) {
        int len = 0;
        int len2 = area;
        int wid = 0;
        int wid2 = 1;

        while (len2 >= wid2) {
            if (len2 * wid2 == area) {
                len = len2;
                wid = wid2;
            }
            wid2++;
            len2 = area / wid2;
        }

        return new int[] {len, wid};
    }
}
