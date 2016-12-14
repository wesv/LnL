package game.element.card;

/**
 * Created by Squiggs on 12/14/2016.
 */
public class Color {
    public static final String RED = "0xFF0000";
    public static final String BLUE = "0x0000FF";
    public static final String GREEN = "0x00FF00";
    public static final String YELLOW = "0xFFFF00";

    private String color;

    public Color(String colorValue) {
        color = colorValue;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Color) && ((Color)o).getColor().equals(this.getColor());
    }

    public String getColor() {
        return color;
    }
}
