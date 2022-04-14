package Maps_Sets_Tables;
/*
https://edabit.com/challenge/MRArkoYdmsxeGAu2s

You prepare a list to send to the insurance company. As you finish, you notice you misformatted it. Given an object with at least
one key/value pair, convert all the values to numbers.
 */

public class InsuranceList {

    // 4/13/2022 solution
    public static Map<String,Integer> convertToNumber(Map<String,String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String item : list.keySet()) {
            int price = Integer.valueOf(list.get(item));
            map.put(item, price);
        }

        return map;
    }
}
