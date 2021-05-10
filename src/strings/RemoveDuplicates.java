package strings;
/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 */

public class RemoveDuplicates {

    /*
    Thought about using a queue to compare top element with element after it but a regular loop would be able to do the same thing
    without extra space. I couldn't wrap my head around using an O(n) solution and thought the string had to be resized after every
    iteration. The next challenge was when to exit the loop when there are no adjacent duplicates in the string. That's the
    reasoning behind why repeat is set to false at the beginning of every loop and set to true if it does encounter a duplicate. I
    also thought to use two StringBuilders because they had be reset once an adjacent duplicate is encountered.

    Top solution turns the string into a char array and only loops through it once. They use a stringbuilder's length for reference
    for duplicates and if there are, they delete the char from the end of the stringbuilder or else they append the char.
     */

    public String removeDuplicates(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder answer = new StringBuilder();

        boolean repeat = true;

        while (repeat) {
            repeat = false;
            for (int i = 1; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) != stringBuilder.charAt(i - 1)) {
                    answer.append(stringBuilder.charAt(i - 1));
                    if (i == stringBuilder.length() - 1) {
                        answer.append(stringBuilder.charAt(i));
                    }
                }
                else {
                    i++;
                    if (i == stringBuilder.length()-1) {
                        answer.append(stringBuilder.charAt(stringBuilder.length() - 1));
                    }
                    repeat = true;
                }
            }

            if (repeat) {
                stringBuilder = answer;
                answer = new StringBuilder();
            }
        }

        return stringBuilder.toString();
    }
}
