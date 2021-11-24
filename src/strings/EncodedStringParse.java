package strings;
/*
https://edabit.com/challenge/gskWj3Zj45ovAomTb

Create a function which takes in an encoded string and returns an object according to the following example:

parseCode("Tesha000Deep00014344") ➞ {
  "firstName"="Tesha",
  "lastName"="Deep",
  "id"="14344"
}
 */

public class EncodedStringParse {

    public static Map<String, String> parseCode(String s) {
        String str = s.replaceAll("0", " ");
        String[] arr = str.split(" ");
        Map<String, String> map = new HashMap<>();
        map.put("firstName", arr[0]);
        map.put("id", arr[arr.length - 1]);

        for (int i = 1; i < arr.length - 1; i++) {
            if (!arr[i].equals("")) {
                map.put("lastName", arr[i]);
                break;
            }
        }

        return map;
    }
}
