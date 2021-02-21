package arrays;
/*
https://leetcode.com/problems/reveal-cards-in-increasing-order/
In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.

Initially, all the cards start face down (unrevealed) in one deck.

Now, you do the following steps repeatedly, until all cards are revealed:

Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.

The first entry in the answer is considered to be the top of the deck.
 */

public class RevealCardsInOrder {

    // Had to use hints to come up with solution
    public int[] deckRevealedIncreasing(int[] deck) {
        //Queue is used to hold the indices for new array
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        Arrays.sort(deck); //Sort deck is ascending order
        int[] arr = new int[deck.length];

        //Every other index is passed to the back of the queue and used later
        for (int card : deck) {
            arr[queue.poll()] = card;
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        return arr;
    }

    // Couldn't come up with solution on my own and had to study and write out given solutions
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] arr = new int[deck.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            queue.add(i);
        }

        Arrays.sort(deck);

        for (int i = 0; i < deck.length; i++) {
            arr[queue.poll()] = deck[i];
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        return arr;
    }
}
