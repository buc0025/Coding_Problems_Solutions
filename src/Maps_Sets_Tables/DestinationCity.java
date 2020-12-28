package Maps_Sets_Tables;
/*
https://leetcode.com/problems/destination-city/
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi.
Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 */

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        String location = "";

        // Beginning and end destination only appears once
        for (List p : paths) {
            for (int i = 0; i < p.size(); i++) {
                if (set.contains(p.get(i))) {
                    set.remove(p.get(i));
                } else {
                    set.add(p.get(i).toString());
                }
            }
        }

        // Remove beginning destination from set
        for (List p : paths) {
            if (set.contains(p.get(0))) {
                set.remove(p.get(0));
            }
        }

        for (String s : set) {
            location += s;
        }

        return location;
    }
}
