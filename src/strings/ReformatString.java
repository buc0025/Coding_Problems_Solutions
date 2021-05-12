package strings;
/*
https://leetcode.com/problems/reformat-the-string/
Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another
digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.
 */
public class ReformatString {

    /*
    I used a stack so I don't have to keep track of how many elements are left for chars or digits. The top solution used 2 lists
    for chars and digits. The first half of the solution is the same as theirs but they only iterated through the string once when
    I had to use a while loop to pop off the stack. They would place either a letter or number in the front depend which one had
    more. If there were 3 letters and 2 numbers, then first element would be a letter. They were able to do this by including logic
    with a boolean for size of both lists and then reverting the boolean at the very end since it wouldn't matter once the first
    element is established.
     */
    public String reformat(String s) {
        int letter = 0;
        int num = 0;
        Stack<Character> letters = new Stack<>();
        Stack<Character> numbers = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                letter++;
                letters.push(c);
            } else {
                num++;
                numbers.push(c);
            }
        }

        if (Math.abs(letter - num) > 1) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        while (!letters.isEmpty() && !numbers.isEmpty()) {
            if (letters.size() >= numbers.size()) {
                result.append(letters.pop());
                result.append(numbers.pop());
            } else {
                result.append(numbers.pop());
                result.append(letters.pop());
            }
        }

        if (!letters.isEmpty()) {
            result.append(letters.pop());
        }

        if (!numbers.isEmpty()) {
            result.append(numbers.pop());
        }

        return result.toString();
    }
}
