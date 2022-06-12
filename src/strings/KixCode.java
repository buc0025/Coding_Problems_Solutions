package strings;
/*
https://edabit.com/challenge/cSfsSmpnGqeAEiN8a

In The Netherlands we have PostNL, the postal company. They use KixCodes, a fast way to deliver letters and packages that can be
scanned during the process.

The code is a combination of: "Postal code", "House/box/call number" and "House appendage / suffix"

If there is a character between the house number and the suffix, we need to replace that with an X. Eventually, the code will be printed in the KixCode font.
 */

public class KixCode {

    // 6/12/2022 solution
    public static String kixCode(String addr) {
        String[] arr = addr.split(", ");
        String house = arr[2].substring(0, 4);
        String box = arr[2].substring(5,7);

        int start = 0;

        for (int i = 0; i < arr[1].length(); i++) {
            if (Character.isDigit(arr[1].charAt(i))) {
                start = i;
                break;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = start; i < arr[1].length(); i++) {
            char n = arr[1].charAt(i);
            if (Character.isDigit(n)) {
                stringBuilder.append(n);
            } else if (Character.isLetter(n)) {
                stringBuilder.append(arr[1].substring(i, i + 1).toUpperCase());
            } else {
                stringBuilder.append('X');
            }
        }

        return house + box + stringBuilder.toString();
    }
}
