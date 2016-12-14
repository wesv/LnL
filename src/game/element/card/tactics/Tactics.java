package game.element.card.tactics;

import game.element.card.MainDeckCard;

/**
 * Created by Squiggs on 12/14/2016.
 */
public abstract class Tactics extends MainDeckCard {
    @Override
    public abstract void resolve(int effectNum);

    @Override
    public void useLogic() {
        resolve(0);
    }
}
