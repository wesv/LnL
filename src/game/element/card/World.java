package game.element.card;

/**
 * Created by Squiggs on 12/14/2016.
 */
public class World {
    public static final String DISFIA = "Disfia";
    public static final String MONOLIUM = "Monolium";
    public static final String SEPTIA = "Septia";
    public static final String TRITOMY = "Tritomy";
    public static final String TETRA_HEAVEN = "Tetra-Heaven";
    public static final String[] ALL_WORLDS = {DISFIA, MONOLIUM, SEPTIA, TRITOMY, TETRA_HEAVEN};

    private String currentWorld;

    /**
     *
     * @param worldName the world that this object represents
     */
    public World(String worldName) {
        assert(isWorld(worldName));

        currentWorld = worldName;
    }

    public static boolean isWorld(String worldName) {
        for(String w: ALL_WORLDS) {
            if(worldName.equalsIgnoreCase(w))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "World: " + currentWorld;
    }

    @Override
    public boolean equals(Object otherWorld) {
        return otherWorld.toString().equals(this.toString());
    }
}
