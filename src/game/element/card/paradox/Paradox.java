package game.element.card.paradox;

import game.element.card.Ability;
import game.element.card.MDCard;

/**
 * Created by Squiggs on 12/14/2016.
 */
public abstract class Paradox extends MDCard {
    protected Ability paradoxRule;

    public void resolve(int x) {
        paradoxRule.resolve(0);
    }
}
