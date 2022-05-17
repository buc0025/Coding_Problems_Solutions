package strings;
/*
https://edabit.com/challenge/bPSi354LyfXhA6RXf

Write a function that receives the time in 12-hour AM/PM format and returns a string representation of the time in military
(24-hour) format.
 */

public class ConvertTime2 {

    // 05/15/2022 solution
    public static String convertTime(String s) {
        String hour = s.substring(0, 2);
        boolean isPM = s.contains("PM");
        if (isPM) {
            if (hour.equals("12")) {
                return s.substring(0, 8);
            } else {
                int addHours = Integer.parseInt(hour) + 12;
                String hours = String.valueOf(addHours);
                return hours + s.substring(2, 8);
            }
        }

        if (hour.equals("12")) {
            return "00" + s.substring(2, 8);
        }

        return s.substring(0, 8);
    }
}
