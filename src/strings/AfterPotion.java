package strings;
/*
https://edabit.com/challenge/rEuWBDwABDMo2rTSt

There are two types of potions:

Growing potion: "A"
Shrinking potion: "B"
If "A" immediately follows a digit, add 1 to the digit.
If "B" immediately follows a digit, subtract 1 from the digit.
Create a function that returns a string according to these rules, removing the potions once they've been consumed.
 */

public class AfterPotion {

    // 5/5/2022 unfinished solution
    public static String afterPotion(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < str.length(); i+=2) {
            if (str.charAt(i) != 'A' && str.charAt(i) != 'B') {
                stringBuilder.append(str.charAt(i - 1));
            } else if (str.charAt(i) == 'A') {
                int n = Integer.valueOf(str.substring(i - 1, i)) + 1;
                stringBuilder.append(n);
            } else {
                int n = Integer.valueOf(str.substring(i - 1, i)) - 1;
                stringBuilder.append(n);
            }
        }

        return stringBuilder.toString();
    }

    public static String afterPotion(String str) {
        String number = "";
        String[] arr = str.split("");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("A")) {
                int num = Integer.parseInt(arr[i - 1]) + 1;
                arr[i - 1] = String.valueOf(num);
                arr[i] = "";
            } else if (arr[i].equals("B")) {
                int num = Integer.parseInt(arr[i - 1]) - 1;
                arr[i - 1] = String.valueOf(num);
                arr[i] = "";
            }
        }

        for (String a : arr) {
            number += a;
        }

        return number;
    }
}
