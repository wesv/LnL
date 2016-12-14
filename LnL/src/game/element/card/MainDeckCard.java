package game.element.card;

/**
 * Created by Squiggs on 12/14/2016.
 */
public abstract class MainDeckCard extends Card implements Logic {
    protected Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }



    public abstract void resolve(int effectNum);
    public abstract void useLogic();

}
