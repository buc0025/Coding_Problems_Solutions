package strings;
/*
https://edabit.com/challenge/CYm9fzo63bQNbWfnN

Create a function that capitalizes the last letter of every word.
 */

public class CapitalizeLastLetter {

    public static String capLast(String str) {
        String[] arr = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i].substring(0, arr[i].length() - 1));
            stringBuilder.append(arr[i].substring(arr[i].length() - 1).toUpperCase());
            stringBuilder.append(" ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }
}
