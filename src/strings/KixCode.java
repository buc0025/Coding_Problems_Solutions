package strings;
/*
https://edabit.com/challenge/cSfsSmpnGqeAEiN8a

In The Netherlands we have PostNL, the postal company. They use KixCodes, a fast way to deliver letters and packages that can be
scanned during the process.

The code is a combination of: "Postal code", "House/box/call number" and "House appendage / suffix"

If there is a character between the house number and the suffix, we need to replace that with an X. Eventually, the code will be printed in the KixCode font.
 */

public class KixCode {

    // 6/8/2022 unfinished solution
    public static String kixCode(String addr) {
        String[] arr = addr.split(", ");
        String house = arr[2].substring(0, 4);
        String box = arr[2].substring(5,7);

        int len = arr[1].length();
        String callNum = arr[1].substring(len - 5);

        return house + box + callNum;
    }
}
