package singly_LinkedLists;
/*
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.
 */

public class ConvertBinary {

    public int getDecimalValue(ListNode head) {
        String num = binaryString(head);

        int answer = 0;
        int base = 1;

        // Converts binary String to integer starting with element at the end of the string
        // and multiplying it with the base. Base doubles at each new place value
        for (int i = num.length() - 1; i >= 0; i--) {
            answer += Integer.valueOf(num.substring(i, i + 1)) * base;
            base = base * 2;
        }

        return answer;
    }

    // Converts elements in linked list to String
    public String binaryString(ListNode head) {
        String result = "";

        while (head != null) {
            result += String.valueOf(head.val);
            head = head.next;
        }

        return result;
    }
}
