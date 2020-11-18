package arrays;
/*
https://leetcode.com/problems/student-attendance-record-i/
You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.
 */
public class AttendanceRecord {

    public boolean checkRecord(String s) {
        int absent = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absent++;
            }
            // Checks for more than two continuous 'L'
            if (i < s.length() - 2) {
                if (s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                    return false;
                }
            }
        }

        return absent <= 1;
    }
}
