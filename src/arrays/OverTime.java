package arrays;
/*
https://edabit.com/challenge/phxxGdTJraPEQmKdq

Write a function that calculates overtime and pay associated with overtime.

Working 9 to 5: regular hours
After 5pm is overtime
Your function gets an array with 4 values:

Start of working day, in decimal format, (24-hour day notation)
End of working day. (Same format)
Hourly rate
Overtime multiplier
Your function should spit out:

$ + earned that day (rounded to the nearest hundreth)
 */

public class OverTime {

    // 4/26/2022 solution
    public static String overTime(double[] arr) {
        double hours = arr[1] - arr[0];
        double multiplier = arr[2] * arr[3];
        double pay = 0;
        String total = "$";

        if (arr[0] >= 17) {
            pay = hours * multiplier;
        } else if (arr[0] + hours > 17) {
            pay += ((17 - arr[0]) * arr[2]);
            pay += ((arr[1] - 17) * multiplier);
        } else {
            pay = hours * arr[2];
        }

        total += String.valueOf(pay);

        int decimal = total.indexOf(".");

        if (total.length() - decimal < 3) {
            total += "0";
        } else {
            total = total.substring(0, decimal + 3);
        }

        return total;
    }

    // Solution doesn't output rounded answer
    public static String overTime(double[] arr) {
        double rate = arr[2];
        double oTRate = arr[3] * arr[2];

        if (arr[0] > 17) {
            double overtime = arr[1] - arr[0];
            return "$" + String.valueOf(overtime * oTRate);
        } else if (arr[1] > 17) {
            double regular = (17 - arr[0]) * rate;
            double overtime = arr[1] - 17;
            return "$" + String.valueOf(regular + overtime * oTRate);
        }

        return "$" + String.valueOf((arr[1] - arr[0]) * arr[2]);
    }
}
