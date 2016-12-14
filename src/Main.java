import game.element.card.World;
import game.element.card.member.Logicalist;
import game.element.field.Deck;

/**
 * Created by Squiggs on 12/14/2016.
 */
public class Main {
    public static void main(String[] args) {
        Deck myDeck = new Deck();

        for(int x = 0; x < 5; x++) {
            myDeck.add(new Logicalist() {
                @Override
                public void resolve(int effectNum) {

                }

                @Override
                public void useLogic() {

                }
            });
        }

        System.out.println(myDeck);

        myDeck.addTo(new Logicalist() {
            @Override
            public void resolve(int effectNum) {

            }

            @Override
            public void useLogic() {

            }
        }, 2);
    }
}
