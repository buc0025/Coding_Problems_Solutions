package arrays;
/*
https://leetcode.com/problems/reformat-date/
Given a date string in the form Day Month Year, where:

Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the range [1900, 2100].
Convert the date string to the format YYYY-MM-DD, where:

YYYY denotes the 4 digit year.
MM denotes the 2 digit month.
DD denotes the 2 digit day.
 */

public class ReformatDate {

    public String reformatDate(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = date.split(" ");

        stringBuilder.append(arr[2] + '-');

        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(arr[1])) {
                if (i < 9) {
                    stringBuilder.append("0" + (i + 1) + "-");
                } else {
                    stringBuilder.append((i + 1) + "-");
                }
            }
        }

        if (arr[0].length() == 3) {
            stringBuilder.append(0 + arr[0].substring(0,1));
        } else {
            stringBuilder.append(arr[0].substring(0,2));
        }

        return stringBuilder.toString();
    }

    public String reformatDate(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        StringBuilder year = new StringBuilder();
        StringBuilder month = new StringBuilder();
        StringBuilder day = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = date.length() - 1; i >= 0; i--) {
            if (i >= date.length() - 4) {
                year.append(date.charAt(i));
            }
            if (i <= date.length() - 6 && i >= date.length() - 8) {
                month.append(date.charAt(i));
            }
            if (i <= date.length() - 10) {
                day.append(date.charAt(i));
            }

        }

        stringBuilder.append(year.reverse());
        stringBuilder.append('-');
        month.reverse();
        day.reverse();

        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(month.toString())) {
                if (i < 9) {
                    stringBuilder.append("0" + (i + 1));
                    stringBuilder.append('-');
                } else {
                    stringBuilder.append(i + 1);
                    stringBuilder.append('-');
                }
            }
        }

        if (day.length() == 3) {
            stringBuilder.append(0 + day.substring(0,1));
        } else {
            stringBuilder.append(day.substring(0,2));
        }

        return stringBuilder.toString();
    }
}
