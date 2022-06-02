package strings;
/*
https://edabit.com/challenge/hLF2GH3SxbsFew3bC

An ice cream sandwich is a string that is formed by two identical ends and a different middle.
 */

public class IsIceCreamSandwich {

    // 6/1/2022 solution
    public static boolean isIcecreamSandwich(String str) {
        if (str.length() < 3) {
            return false;
        }

        int frontEnd = 0;
        int middleStart = 0;
        int middleEnd = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                frontEnd = i - 1;
                middleStart = frontEnd + 1;
                break;
            }
        }

        for (int i = middleStart + 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                middleEnd = i - 1;
                break;
            }
        }

        if (!str.substring(0, frontEnd + 1).equals(str.substring(middleEnd + 1))) {
            return false;
        }

        return true;
    }
}
