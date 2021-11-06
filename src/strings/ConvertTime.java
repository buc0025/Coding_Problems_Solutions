package strings;
/*
https://edabit.com/challenge/ayvtiYuzTxkphRBxB

Create a function that converts 12-hour time to 24-hour time or vice versa. Return the output as a string.
 */

public class ConvertTime {

    public static String convertTime(String time) {
        StringBuilder result = new StringBuilder();
        int separator = time.indexOf(":");
        int hours = Integer.parseInt(time.substring(0, separator));
        String mins = time.substring(separator + 1, separator + 3);

        if (time.contains("am") || time.contains("pm")) {
            if (hours + 12 == 24) {
                result.append("0:");
                result.append(mins);
            } else {
                result.append(hours + 12);
                result.append(":");
                result.append(mins);
            }
            return result.toString();
        }

        if (hours == 12) {
            result.append("0:");
            result.append(mins);
            result.append(" am");
        }

        if (hours < 12) {
            result.append(hours);
            result.append(":");
            result.append(mins);
            result.append(" am");
        } else {
            result.append(hours - 12);
            result.append(":");
            result.append(mins);
            result.append(" pm");
        }

        return result.toString();
    }
}
