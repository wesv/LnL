package game.element.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Squiggs on 12/16/2016.
 */
public class ShuffleList<T> {

    protected static final double BELL_CURVE_SD = 1.0/2.0;

    public void shuffle(final List<T> list) {
        cut(list);
        cut(list);
       // cut(list);

    }

    /**
     * Approximates a normal bell curve distribution
     * @param x a value between 0 and 1
     * @param standardDeviation how "wide" the bell curve is. The smaller the value, the tighter the curve
     * @return the y value in a normal distribution
     */
    private double bellCurve(double x, double standardDeviation) {
        double constant = 1.0/Math.sqrt(2 * Math.PI);
        double exponent = (-1/standardDeviation * x * x);

        return constant * Math.pow(Math.E, exponent);
    }

    /**
     * Cuts the deck in a random location weighted more heavily towards the center
     * @param list the list that will be cut.
     */
    private void cut(final List<T> list) {
        int humanCurError = (int) Math.round(bellCurve(Math.random(), BELL_CURVE_SD) * list.size() / 2.0);

        //Chance for the cut to go both ways
        if(Math.random() > 0.5)
            humanCurError *= -1;

        int firstHalfSize = list.size() / 2 + humanCurError;
        int secondHalfSize = list.size() - firstHalfSize;

        Collection<T> firstHalf = new ArrayList<>(firstHalfSize);
        Collection<T> secondHalf = new ArrayList<>(secondHalfSize);

        //Get first half of list
        for(int x = 0; x < firstHalfSize; x++) {
            firstHalf.add(list.remove(0));
        }

        //Get the Second half of the list
        for(int x = 0; x < secondHalfSize; x++) {
            secondHalf.add(list.remove(0));
        }

        //Cut the list
        list.addAll(secondHalf);
        list.addAll(firstHalf);
        System.out.println(list);
    }

}
