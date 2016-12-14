package game.element.card;

/**
 * Created by Squiggs on 12/14/2016.
 */
public abstract class Card implements Ability {
    protected World world;

    protected String cardName;
    protected String flavor;

    public World getWorld() {
        return world;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getCardName() {
        return cardName;
    }

    public abstract void resolve(int effectNum);

}
