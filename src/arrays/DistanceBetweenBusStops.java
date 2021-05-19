package arrays;
/*
https://leetcode.com/problems/distance-between-bus-stops/
A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where
distance[i] is the distance between the stops number i and (i + 1) % n.

The bus goes along both directions i.e. clockwise and counterclockwise.

Return the shortest distance between the given start and destination stops.
 */

public class DistanceBetweenBusStops {

    /*
    Since the bus stops form a circle, we only have to find the shorter distance between the clockwise direction and counterclockwise
    direction of start and destination. The first loop is for clockwise direction while the second and third loop are for counter-
    clockwise which goes out of range. The third loop handles the out of range by starting at index 0 to the start.
     */
    public int distanceBetweenBusStops(int[] distance, int start, int dest) {
        int forward = 0;
        int back = 0;

        int startFirst = Math.min(start, dest);
        int endLast = Math.max(start, dest);

        for (int i = startFirst; i < endLast; i++) {
            forward += distance[i];
        }

        for (int i = endLast; i < distance.length; i++) {
            back += distance[i];
        }

        for (int i = 0; i < startFirst; i++) {
            back += distance[i];
        }

        return Math.min(forward, back);
    }
}
