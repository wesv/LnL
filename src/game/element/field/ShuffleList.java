package game.element.field;

import java.util.*;

/**
 * Created by Squiggs on 12/16/2016.
 */
public class ShuffleList<T> {

    protected static final double BELL_CURVE_SD = 1.0/2.0;

    public void shuffle(final List<T> list) {
        cutDeck(list);
        cutDeck(list);
//       cut(list, new ArrayList<T>(), new ArrayList<T>(), new ArrayList<T>());

    }

    /**
     * Approximates a normal bell curve distribution
     * @param x a value between 0 and 1
     * @param standardDeviation how "wide" the bell curve is. The smaller the value, the tighter the curve
     * @return the y value in a normal bell curve distribution
     */
    private double bellCurve(double x, double standardDeviation) {
        double constant = 1.0/Math.sqrt(2 * Math.PI);
        double exponent = (-1/standardDeviation * x * x);

        return constant * Math.pow(Math.E, exponent);
    }

    /**
     * Cuts the deck in a random location weighted more heavily towards the center
     * The list object given will have been cut.
     * @param list the list that will be cut.
     */
    private void cutDeck(final List<T> list) {

        List<T> firstHalf = new LinkedList<>();
        List<T> secondHalf = new LinkedList<>();

        //Cut the list into two parts: the first half, and the second half
        cut(list, firstHalf, secondHalf);

        list.addAll(secondHalf);
        list.addAll(firstHalf);
        System.out.println(list);
    }

    /**
     * Cuts a list into any number of other lists. This specific instance of cut will cut the list into approximately equally.
     * At the end of the function, all of the elements in list will be placed into all lists in listsToSplitTo.
     * This method calculates human error by approximating a bell curve distribution and mapping it appropriately to each list to split to.
     *
     *
     * @param list the list to split
     * @param listToSplitTo an output parameter that the list will split into
     */
    private void cut(final List<T> list, final List<T>... listToSplitTo) {
        int numLists = listToSplitTo.length;
        int[] cardsPerList = new int[numLists];

        { // Init cardsPerList appropriately for the situation
            int numCardsTaken = 0;
            int remainingCards;
            int remainingLists;
            int humanCutError;

            for (int x = 0; x < numLists - 1; x++) {

                remainingCards = (list.size() - 1) - numCardsTaken;
                remainingLists = numLists - x;

                humanCutError = (int) Math.round(bellCurve(Math.random(), BELL_CURVE_SD) * remainingCards / remainingLists);
                if (Math.random() > 0.5)
                    humanCutError *= -1;

                cardsPerList[x] = remainingCards / remainingLists + humanCutError;
                numCardsTaken += cardsPerList[x];
            }

            cardsPerList[numLists - 1] = list.size() - numCardsTaken;
        }

        { // Add elements from list into the appropriate listToSplitTo
            for (int subset = 0; subset < numLists; subset++) {
                for (int x = 0; x < cardsPerList[subset]; x++) {
                    listToSplitTo[subset].add(list.remove(0));
                }
            }
        }


    }

}
