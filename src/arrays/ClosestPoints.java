package arrays;
/*
https://leetcode.com/problems/k-closest-points-to-origin/
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 */

public class ClosestPoints {

    // Passes 81/83 test cases
    public int[][] kClosest(int[][] points, int k) {
        //Stores square roots of hypotenuse
        double[] arr = new double[points.length];

        // map contains hypotenuse of point and (0,0) for keys, and array of points for values
        Map<Double, int[]> map2 = new HashMap<>();

        int index = 0;

        for (int[] point : points) {
            int point1 = point[0] * point[0];
            int point2 = point[1] * point[1];
            arr[index] = Math.sqrt(point1 + point2);
            map2.put(arr[index], point);
            index++;
        }

        Arrays.sort(arr);

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            ans[i][0] = map2.get(arr[i])[0];
            ans[i][1] = map2.get(arr[i])[1];
        }

        return ans;
    }
}
