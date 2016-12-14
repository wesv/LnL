package game.element.field;

import game.element.card.MDCard;

import java.util.Arrays;

/**
 * Data Structure used for the deck.
 *
 * This deck will have it's top most card at index of currentDeckSize-1.
 */
public class Deck {
    public static final int MAX_DECK_SIZE = 50;
    
    private MDCard[] deck;
    private int currentDeckSize;

    public Deck() {
        deck = new MDCard[MAX_DECK_SIZE];
        currentDeckSize = 0;
    }

    public Deck(MDCard... cards) {
        this();
        for(MDCard c: cards)
            this.add(c);
    }

    /**
     * Adds a card to the top of the deck
     * @param card the card to add
     * @throws ArrayIndexOutOfBoundsException if you try to add a card to a full deck.
     */
    public void add(MDCard card) {
        if(currentDeckSize >= MAX_DECK_SIZE)
            throw new ArrayIndexOutOfBoundsException("Can't add a card to a full deck");

        deck[currentDeckSize] = card;
        currentDeckSize++;
    }

    public void addTo(MDCard card, int location) {
        if(location >= currentDeckSize) {
            this.add(card);
        }
        else {
            for (int x = currentDeckSize; x > location; x--) {
                deck[x] = deck[x-1];
            }
            deck[location] = card;
        }
    }

    /**
     * Removes the card at index and moves the rest of the deck to fill in the empty space
     * @param index the index of the card to remove
     * @return the card removed
     */
    public MDCard remove(int index) {
        //TODO
        return null;
    }

    /**
     * Draws the top card of the deck and returns it
     * @return the top card of the deck
     */
    public MDCard draw() {
        //TODO
        return null;
    }

    public void shuffle() {
        //TODO shuffle the cards
    }

    public int getCurrentDeckSize() {

    }

    public void addToTop(MDCard card) {
        this.add(card);
    }

    public void addToBottom(MDCard card) {
        this.addTo(card, 0);
    }


    @Override
    public String toString() {
        return Arrays.toString(deck);
    }
}
