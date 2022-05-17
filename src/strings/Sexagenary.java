package strings;
/*
https://edabit.com/challenge/pnhcp4FraYQDeqRGt

In early recorded Chinese history, time was reckoned using the sexagenary (60-year) cycle, generated from two subcycles:

Five heavenly stems (elements) in this order: wood, fire, earth, metal, water. The stems change every two years.
Twelve earthly branches (animals) in this order: rat, ox, tiger, rabbit, dragon, snake, horse, sheep, monkey, rooster, dog, pig.
The branches change yearly.
The combinations between these two sub-cycles result in a 60-year cycle where no two years are the same — for example, the 5
years of the Rat have 5 different elements: 1924 Wood Rat, 1936 Fire Rat, 1948 Earth Rat, 1960 Metal Rat, 1972 Water Rat.
 */

public class Sexagenary {

    // 5/16/2022 solution
    public static String sexagenary(int year) {
        Map<Integer, String> branches = new HashMap<>();
        branches.put(1984, "Rat");
        branches.put(1985, "Ox");
        branches.put(1986, "Tiger");
        branches.put(1987, "Rabbit");
        branches.put(1988, "Dragon");
        branches.put(1989, "Snake");
        branches.put(1990, "Horse");
        branches.put(1991, "Sheep");
        branches.put(1992, "Monkey");
        branches.put(1993, "Rooster");
        branches.put(1994, "Dog");
        branches.put(1995, "Pig");

        Map<Integer, String> stems = new HashMap<>();
        stems.put(0, "Metal");
        stems.put(1, "Metal");
        stems.put(2, "Water");
        stems.put(3, "Water");
        stems.put(4, "Wood");
        stems.put(5, "Wood");
        stems.put(6, "Fire");
        stems.put(7, "Fire");
        stems.put(8, "Earth");
        stems.put(9, "Earth");

        String stem = stems.get(year % 10);
        String branch = "";

        if (year < 1984) {
            for (int i = year; i <= 1995; i+=12) {
                if (branches.containsKey(i)) {
                    branch = branches.get(i);
                    break;
                }
            }
        } else if (year > 1995) {
            for (int i = year; i >= 1582; i-=12) {
                if (branches.containsKey(i)) {
                    branch = branches.get(i);
                    break;
                }
            }
        } else {
            branch = branches.get(year);
        }

        return stem + " " + branch;
    }
}
