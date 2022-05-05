package strings;
/*
https://edabit.com/challenge/GqqYA3RKuok5Pw2Bx

Create a function that takes a string of 1's and 0's (binary) as an argument and return the equivalent decoded ASCII text.
Characters can be in the range of "00000000" to "11111111", which means every eight digits of binary input represents a single
character.

a = 01100001
b = 01100010
c = 01100011
If you were to combine these characters into the string "abc", the corresponding binary would be 011000010110001001100011.
 */

public class BinaryConversion {

    // 5/4/2022 solution
    public static String binaryConversion(String bin) {
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < bin.length(); i+=8) {
            list.add(bin.substring(i, i + 8));
        }

        for (String letter : list) {
            int ascii = Integer.parseInt(letter, 2);
            stringBuilder.append((char)ascii);
        }

        return stringBuilder.toString();
    }
}
