package arrays;
/*
https://edabit.com/challenge/BMpe6n3BSciWnt3fu

Find out if a right-angled triangle can be made given some facts about the shape.

Given varying information about a shape, create a function that returns true if the shape could be a right-angle triangle and
false if not.
You will be given an array of numbers and a string stating whether the numbers are angles or sides.
The information may indicate more than one possible shape, but we just need to know if these details could be found in a
right-angled triangle.
 */

public class IsRightAngle {

    //Still not passing 3 test cases dealing with angles going over 180
    public static boolean isRightAngle(int[] arr, String desc) {
        Arrays.sort(arr);

        if (arr.length > 3) {
            return false;
        }

        if (arr.length == 0) {
            return true;
        }

        int sum = 0;

        for (int a : arr) {
            sum += a;
        }

        if (desc.equals("angle")) {
            if (180 - sum == 90) {
                return true;
            } else if (sum <= 180) {
                for (int a : arr) {
                    if (a == 90) {
                        return true;
                    }
                }
            }
            return false;
        }

        if (arr.length == 3) {
            if (Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isRightAngle(int[] arr, String desc) {
        Arrays.sort(arr);

        if (arr.length > 3) {
            return false;
        }

        int sumAngles = 0;

        if (desc.equals("angle")) {
            for (int a : arr) {
                if (a == 90) {
                    return true;
                } else {
                    sumAngles += a;
                }
            }

            if (180 - sumAngles == 90) {
                return true;
            }

            return false;
        }

        if (arr.length == 3) {
            if (Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2)) {
                return true;
            }
        }

        return false;
    }
}
