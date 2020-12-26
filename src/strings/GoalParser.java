package strings;
/*
https://leetcode.com/problems/goal-parser-interpretation/
You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some
order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The
interpreted strings are then concatenated in the original order.

Given the string command, return the Goal Parser's interpretation of command.
 */

public class GoalParser {

    public String interpret(String command) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                stringBuilder.append("G");
            }
            if (i <= command.length() - 4 && command.substring(i, i + 4).equals("(al)")) {
                stringBuilder.append("al");
            }
            if (i <= command.length() - 2 && command.substring(i, i + 2).equals("()")) {
                stringBuilder.append("o");
            }
        }

        return stringBuilder.toString();
    }
}
