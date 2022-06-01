package strings;
/*
https://edabit.com/challenge/hLF2GH3SxbsFew3bC

An ice cream sandwich is a string that is formed by two identical ends and a different middle.
 */

public class IsIceCreamSandwich {

    // 5/31/2022 unfinished solution
    public static boolean isIcecreamSandwich(String str) {
        if (str.length() < 3) {
            System.out.println(false);
        }

        String front = str.substring(0,1);
        String middle = "";
        String end = str.substring(str.length() - 1);

        System.out.println(front);
        System.out.println(middle);

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                break;
            } else {
                front += str.substring(i, i + 1);
            }
        }
    }
}
