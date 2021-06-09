package strings;
/*
Mock interview problem from Jason 6/9/2021. Given a string, convert it to an integer without using built-in functions.
ex. "000123" -> 123
 */

public class AsciiToInteger {

    // Messed up on trying to throw exception if char is not a number
    public static int aToI(String number) {
        int result = 0;
        int base = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            char num = number.charAt(i);
            if (isIntegerValue(num)) {
                result += getIntegerValue(num) * Math.pow(10, base);
                base++;
            } else {
                throw Exception;
            }
        }

        return result;
    }

    public static boolean isIntegerValue(char c) {
        Set<Character> set = new HashSet<>();
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');

        if (set.contains(c)) {
            return true;
        } else {
            return false;
        }
    }

    public static int getIntegerValue(char c) {
        switch (c) {
            case '0':
                return 0;
            break;
            case '1':
                return 1;
            break;
            case '2':
                return 2;
            break;
            case '3':
                return 0;
            break;
            case '4':
                return 0;
            break;
            case '5':
                return 0;
            break;
            case '6':
                return 0;
            break;
            case '7':
                return 0;
            break;
            case '8':
                return 0;
            break;
            case '9':
                return 0;
            break;
        }
}
