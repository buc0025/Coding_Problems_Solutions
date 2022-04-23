package strings;
/*
https://edabit.com/challenge/ka4Mk98LW4TEbcqzH

Create a function that takes a string as an argument and returns true if each letter in the string is surrounded by a plus sign.
Return false otherwise.
 */

public class PlusSign {

    // 4/22/2022 solution
    public static boolean plusSign(String str) {
        if (str.charAt(0) - 'a' >= 0 && str.charAt(0) - 'a' <= 26) {
            return false;
        }

        if (str.charAt(str.length() - 1) - 'a' >= 0 && str.charAt(str.length() - 1) - 'a' <= 26) {
            return false;
        }

        String[] arr = str.split("[+]");

        for (String a : arr) {
            if (a.length() > 1) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) - 'a' >= 0 && a.charAt(i) - 'a' <= 26) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
