package arrays;
/*
https://edabit.com/challenge/rCkeAiRCpduosZ4Hj

Create a function that returns true if each pair of adjacent numbers in an array shares at least one digit and false otherwise.
 */

public class SharedDigits {

    // 5/8/2022 solution
    public static boolean sharedDigits(int[] num) {
        boolean shared = false;
        for (int i = 0; i < num.length - 1; i++) {
            Set<Character> set = new HashSet<>();
            String number1 = String.valueOf(num[i]);
            String number2 = String.valueOf(num[i + 1]);
            for (int j = 0; j < number1.length(); j++) {
                set.add(number1.charAt(j));
            }
            for (int k = 0; k < number2.length(); k++) {
                if (set.contains(number2.charAt(k))) {
                    shared = true;
                    break;
                }
            }
            if (!shared) {
                return false;
            }
            shared = false;
        }

        return true;
    }
}
