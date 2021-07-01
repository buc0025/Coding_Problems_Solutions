package strings;
/*
https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
Given a string s containing only lower case English letters and the '?' character, convert all the '?' characters into lower case
letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.

It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.

Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any
of them. It can be shown that an answer is always possible with the given constraints.
 */

public class ReplaceAllQuestionMarks {

    public String modifyString(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) == '?') {
                return "a";
            } else {
                return s;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            char question = s.charAt(i);

            if (question == '?' && i == 0) {
                if (s.charAt(i + 1) == 'a' || s.charAt(i + 1) == '?') {
                    stringBuilder.append('b');
                } else {
                    stringBuilder.append('a');
                }
            } else if (question == '?' && s.charAt(i + 1) == '?') {
                if (stringBuilder.charAt(i - 1) == 'b') {
                    stringBuilder.append('c');
                } else {
                    stringBuilder.append('b');
                }
            } else if (question == '?' && s.charAt(i + 1) == 'a') {
                if (stringBuilder.charAt(i - 1) == 'b') {
                    stringBuilder.append('c');
                } else {
                    stringBuilder.append('b');
                }
            }else if (question == '?' && s.charAt(i + 1) == 'b') {
                if (stringBuilder.charAt(i - 1) == 'a') {
                    stringBuilder.append('c');
                } else {
                    stringBuilder.append('a');
                }
            } else if (question == '?' && s.charAt(i + 1) == 'c') {
                if (stringBuilder.charAt(i - 1) == 'a') {
                    stringBuilder.append('b');
                } else {
                    stringBuilder.append('a');
                }
            } else if (question == '?') {
                if (stringBuilder.charAt(i - 1) == 'a') {
                    stringBuilder.append('b');
                } else {
                    stringBuilder.append('a');
                }
            } else {
                stringBuilder.append(question);
            }
        }


        if (s.charAt(s.length() - 1) == '?') {
            if (s.charAt(s.length() - 2) == 'a') {
                stringBuilder.append('b');
            } else {
                stringBuilder.append('a');
            }
        } else {
            stringBuilder.append(s.charAt(s.length() - 1));
        }

        return stringBuilder.toString();
    }
}


