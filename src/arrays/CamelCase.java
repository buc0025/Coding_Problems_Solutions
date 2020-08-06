package arrays;
/*
https://edabit.com/challenge/sF6Lm5LQsy6u2ZKeZ
Create a function that converts dash/underscore delimited words into camel casing. The first word within the output
should be capitalized only if the original word was capitalized.
Examples:
toCamelCase("A-B-C") ➞ "ABC"
toCamelCase("the-stealth-warrior") ➞ "theStealthWarrior"
toCamelCase("The_Stealth_Warrior") ➞ "TheStealthWarrior"
 */

public class CamelCase {

    public static String toCamelCase(String str) {
        String[] arr1 = str.split("_");
        String[] arr2 = str.split("-");
        String result1 = arr1[0];
        String result2 = arr2[0];

        if (str.length() == 0) {
            return "";
        }

        if (str.contains("_")) {
            for (int i = 1; i < arr1.length; i++) {
                String up1 = arr1[i].substring(0,1);
                result1 += up1.toUpperCase() + arr1[i].substring(1);

            }
            return result1;
        } else {
            for (int i = 1; i < arr2.length; i++) {
                String up2 = arr2[i].substring(0,1);
                result2 += up2.toUpperCase() + arr2[i].substring(1);

            }
            return result2;
        }
    }
}
