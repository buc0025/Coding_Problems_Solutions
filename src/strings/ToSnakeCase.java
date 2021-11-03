package strings;
/*
https://edabit.com/challenge/HjvecTb3aFMjJ59sB

Create a function that takes a single string and converts it into camel case.
 */

public class ToSnakeCase {

    public static String toSnakeCase(String str) {
        StringBuilder snakeCase = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                snakeCase.append('_');
                snakeCase.append(str.substring(i, i + 1).toLowerCase());
            } else {
                snakeCase.append(str.charAt(i));
            }
        }

        return snakeCase.toString();
    }
}
