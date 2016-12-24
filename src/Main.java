import game.element.card.World;
import game.element.card.member.Logicalist;
import game.element.field.Deck;
import game.element.field.ShuffleList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Squiggs on 12/14/2016.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> test = new LinkedList<>();

        for(int x = 0; x < 50; x++){
            test.add(x/4 + 1);
        }

        System.out.println(test);

        new ShuffleList<Integer>().shuffle(test);
        System.out.println(test);
    }
}
