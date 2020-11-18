package Maps_Sets_Tables;
/*
https://leetcode.com/problems/network-delay-time/
There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target
node, and w is the time it takes for a signal to travel from source to target.
Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 */

public class NetworkDelay {

    **************Incorrect attempt*****************

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Integer> map = new HashMap<>();

        // Finding which nodes have a direct connection with K
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times[i].length; j++) {
                if (times[i][0] == K) {
                    map.put(times[i][1], K);
                }
            }
        }

        // Finding rest of the nodes that have indirect connections with K
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times[i].length; j++) {
                if (map.containsKey(times[i][0])) {
                    map.put(times[i][1], times[i][0]);
                }
            }
        }

        // Nodes in map have direct or indirect connection with K. Number of nodes in map plus
        // given node should equal to total number of nodes
        if (map.size() + 1 != N) {
            return -1;
        }

        // Don't know how to figure out how long it will take for all nodes to receive the signal
        return ???
    }
}
