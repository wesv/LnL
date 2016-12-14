package game.element.card.gate;

import game.element.card.Card;

/**
 * Created by Squiggs on 12/14/2016.
 */
public class Gate extends Card {
    private int gateNumber;

    public Gate(int num)
    {
        gateNumber = num;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    @Override
    public void resolve(int effectNum) {

    }
}
