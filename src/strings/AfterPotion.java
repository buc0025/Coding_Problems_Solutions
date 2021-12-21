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
