package strings;
/*
https://leetcode.com/problems/day-of-the-year/
Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
 */

public class DayOfTheYear {

    public int dayOfYear(String date) {
        String[] arr = date.split("-");
        int year = Integer.valueOf(arr[0]);
        int month = Integer.valueOf(arr[1]);
        int day = Integer.valueOf(arr[2]);
        int count = 0;

        if (month > 2) {
            if (year % 4 == 0 || year % 100 == 0) {
                count = 1;
            }
        }

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        for (int i = 0; i < month - 1; i++) {
            count += days[i];
        }

        return count + day;
    }
}
