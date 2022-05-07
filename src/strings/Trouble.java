package strings;
/*
https://edabit.com/challenge/27h4mwAKD3hhy6onh

Create a function that takes two integers and returns true if a digit repeats three times in a row at any place in num1 AND that
same digit repeats two times in a row in num2.
 */

public class Trouble {

    // 5/6/2022 solution
    public static boolean trouble(long num1, long num2) {
        String n1 = String.valueOf(num1);
        String n2 = String.valueOf(num2);

        if (n1.length() < 3 || n2.length() < 2) {
            return false;
        }

        for (int i = 0; i < n1.length() - 2; i++) {
            if (n1.charAt(i) == n1.charAt(i + 1) && n1.charAt(i) == n1.charAt(i + 2)) {
                String num = n1.substring(i, i + 2);
                for (int j = 0; j < n2.length() - 1; j++) {
                    if (n2.substring(j, j + 2).equals(num)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
