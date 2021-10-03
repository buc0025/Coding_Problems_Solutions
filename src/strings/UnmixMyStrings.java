package strings;
/*
https://edabit.com/challenge/XRAGxXj4KtakkvD3F

lPaeesh le pemu mnxit ehess rtnisg! Oh, sorry, that was supposed to say: Please help me unmix these strings!

Somehow my strings have all become mixed up; every pair of characters has been swapped. Help me undo this so I can understand my
strings again.

The length of a string can be odd — in this case the last character is not altered (as there's nothing to swap it with).
 */

public class UnmixMyStrings {

    public static String unmix(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < str.length(); i+=2) {
            char swap1 = str.charAt(i);
            char swap2 = str.charAt(i - 1);

            stringBuilder.append(swap1);
            stringBuilder.append(swap2);
        }

        if (str.length() % 2 == 1) {
            stringBuilder.append(str.charAt(str.length() - 1));
        }

        return stringBuilder.toString();
    }
}
