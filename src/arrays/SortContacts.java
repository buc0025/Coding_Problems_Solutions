package arrays;
/*
https://edabit.com/challenge/SnZ5y2hyxjZnWrMec

Write a sorting function that takes in an array of names and sorts them by last name either alphabetically (ASC) or
reverse-alphabetically (DESC).
 */

public class SortContacts {

    // 6/17/2022 unfinished solution
    public static String[] sortContacts(String[] arr, String sortBy) {
        String[] result = new String[arr.length];
        String[] lastNames = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int start = 0;
            if (arr[i].contains(" ")) {
                start = arr[i].indexOf(" ") + 1;
                lastNames[i] = arr[i].substring(start);
            } else {
                lastNames[i] = arr[i];
            }
        }

        Arrays.sort(lastNames);

        if (sortBy.equals("DESC")) {
            for (int i = 0; i < lastNames.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j].contains(lastNames[i])) {
                        result[i] = arr[j];
                        break;
                    }
                }
            }
        } else {
            int index = 0;
            for (int i = lastNames.length - 1; i >= 0; i--) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j].contains(lastNames[i])) {
                        result[index] = arr[j];
                        index++;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
