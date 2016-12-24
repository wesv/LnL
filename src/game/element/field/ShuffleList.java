package game.element.field;

import java.util.*;

/**
 * Created by Squiggs on 12/16/2016.
 */
public class ShuffleList<T> {

    protected static final double BELL_CURVE_SD = 1.0/3.0;

    public void shuffle(final List<T> list) {
        riffle(list);
        //cutDeck(list);
        //cutDeck(list);
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

                remainingCards = list.size() - numCardsTaken;
                remainingLists = numLists - x;

                //Get the bell curve value at random x between 0-1, then map that random value to how many cards are left with how many buckets are left
                humanCutError = (int) Math.round(bellCurve(Math.random(), BELL_CURVE_SD) * remainingCards / remainingLists);
                if (Math.random() > 0.5)
                    humanCutError *= -1;

                //TODO remove this line. This is a temp line to remove the human error in the cut for testing other parts
                humanCutError = 0;

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

    public void riffle(final List<T> list) {
        List<T> left  = new LinkedList<>();
        List<T> right = new LinkedList<>();

        cut(list, left, right);

        //System.out.println(left);
        //System.out.println(right);

        /*int minSize = Math.min(left.size(), right.size());
        for(int x=0; x < minSize; x++) {
            list.add(left.remove(0));
            list.add(right.remove(0));
        }*/
//TODO this needs fixed
        System.out.println(bellCurve(0, BELL_CURVE_SD));
        System.out.println(bellCurve(, BELL_CURVE_SD));
        while(!(left.isEmpty() || right.isEmpty())){
            int sizeDif = Math.abs(left.size()-right.size());

            /*
            sizeDif = 0: 50% chance of either
            sizeDif = 1; 60% chance of lower side
            sizeDif = 2; 70% chance of lower side
            sizeDif = 3: 80% chance of lower side
            sizeDif = 4:

             */

            double lowersChance = 0.5 + 0.5/15 * sizeDif;

            List<T> lower = left.size() <= right.size() ? left: right;
            List<T> higher = left.size() > right.size() ? left: right;

            if(Math.random() > lowersChance) {
                list.add(lower.remove(0));
            } else
                list.add(higher.remove(0));
            /*
            double leftChance = bellCurve(Math.random(), BELL_CURVE_SD) * right.size();
            double rightChance = bellCurve(Math.random(), BELL_CURVE_SD) * left.size();
            if(leftChance > rightChance)
                list.add(left.remove(0));
            else
                list.add(right.remove(0));
*/
            /*if(left.size() > right.size())
                list.add(left.remove(0));
            else if(right.size() > left.size())
                list.add(right.remove(0));
            else {
                if(Math.random() > 0.5)
                    list.add(left.remove(0));
                else
                    list.add(right.remove(0));
            }*/
        }


            //Add the rest of the elements from the left, if any
        while(!left.isEmpty()) list.add(left.remove(0));

        //ADd the rest of the elements from the right, if any
        while(!right.isEmpty()) list.add(right.remove(0));



    }

}
