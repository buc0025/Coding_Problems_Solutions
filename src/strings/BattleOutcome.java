package strings;
/*
https://edabit.com/challenge/42DtofyzmZXjWXCtw

Starting from the left side of an integer, adjacent digits pair up in "battle" and the larger digit wins. If two digits are the
same, they both lose. A lone digit automatically wins.

Create a function that returns the victorious digits.
 */

public class BattleOutcome {

    // 4/21/2022
    public static int battleOutcome(int num) {
        String res = "";
        String number = String.valueOf(num);

        for (int i = 0; i < number.length() - 1; i+=2) {
            int left = Integer.parseInt(number.substring(i, i + 1));
            int right = Integer.parseInt(number.substring(i + 1, i + 2));

            if (left > right) {
                res += String.valueOf(left);
            } else if (right > left) {
                res += String.valueOf(right);
            }
        }

        if (number.length() % 2 == 1) {
            res += number.substring(number.length() - 1);
        }

        return Integer.parseInt(res);
    }
}
