package strings;
/*
https://edabit.com/challenge/g5n85W62rJqZakMry

Create a function which replaces all the x's in the string in the following ways:

Replace all x's with "cks" UNLESS:

The word begins with "x", therefore replace it with "z".
The word is just the letter "x", therefore replace it with "ecks".
 */

public class PronouncingTheXs {

    public static String xPronounce(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            int len = word.length();
            if (word.equals("x")) {
                stringBuilder.append("ecks");
            } else if (word.charAt(0) == 'x') {
                stringBuilder.append("z");
                stringBuilder.append(word.substring(1));
            } else {
                stringBuilder.append(word);
            }
            stringBuilder.append(" ");
        }

        return stringBuilder.substring(0, stringBuilder.length() - 1).toString();
    }
}
