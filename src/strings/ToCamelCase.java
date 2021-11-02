package strings;
/*
https://edabit.com/challenge/HjvecTb3aFMjJ59sB

Create a function that takes a single string and converts it into camel case.
 */

public class ToCamelCase {

    public static String toCamelCase(String str) {
        StringBuilder camelCase = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                char upper = str.toUpperCase().charAt(i + 1);
                camelCase.append(upper);
                i++;
            } else {
                camelCase.append(str.charAt(i));
            }
        }

        return camelCase.toString();
    }
}
