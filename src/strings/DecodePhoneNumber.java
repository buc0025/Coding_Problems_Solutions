package strings;
/*
https://edabit.com/challenge/8NZaLdJBkhZCgNBc7

Create a program that converts a phone number with letters to one with only numbers.
 */

public class DecodePhoneNumber {

    //Use replaceAll method instead of for loops and sets
    public static String textToNum(String phone) {
        StringBuilder number = new StringBuilder();
        Set<String> set = new HashSet<>();

        for (int i = 0; i <= 9; i++) {
            set.add(String.valueOf(i));
        }

        set.add("(");
        set.add(")");
        set.add("-");

        for (int i = 0; i < phone.length(); i++) {
            char num = phone.charAt(i);
            if (set.contains(phone.substring(i, i + 1))) {
                number.append(phone.charAt(i));
            } else if (num >= 65 && num <= 67) {
                number.append("2");
            } else if (num >= 68 && num <= 70) {
                number.append("3");
            } else if (num >= 71 && num <= 73) {
                number.append("4");
            } else if (num >= 74 && num <= 76) {
                number.append("5");
            } else if (num >= 77 && num <= 79) {
                number.append("6");
            } else if (num >= 80 && num <= 83) {
                number.append("7");
            } else if (num >= 84 && num <= 86) {
                number.append("8");
            } else {
                number.append("9");
            }
        }

        return number.toString();
    }
}
