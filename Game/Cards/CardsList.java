package edu.kit.informatik.Game.Cards;

import edu.kit.informatik.Terminal;

import java.util.ArrayList;

/**
 * This class represents the Array List that contains the cards.
 *
 * @author Mustafa Sayin
 * @version 1.0
 */

public class CardsList {
    /**
     * This is the Array List that represents the deck with the cards.
     */
    ArrayList<Card> deckWithCards = new ArrayList<>();
    /**
     * This is the Array List that represents the bag with the resources that are drawn.
     */
    ArrayList<Card> resourcesBag = new ArrayList<>();

    /**
     * @return the Array List that contain the deck with the cards.
     */
    public ArrayList<Card> getDeckWithCards() {
        return deckWithCards;
    }

    /**
     * This method draw a card from the deck (Array List).
     *
     * @return the card that is drawn from the deck.
     */
    public Card draw() {
        Card result = null;
        if (deckWithCards.size() != 0) {
            result = deckWithCards.get(0);
            deckWithCards.remove(0);
            return result;
        }
        return null;
    }

    /**
     * This method add a card to the deck.
     *
     * @param card that will be added to the deck (Array List).
     */
    public void addCards(Card card) {
        deckWithCards.add(card);
    }

    /**
     * This method add a resource (Card with the card typ resource) to the resource bag.
     *
     * @param resources that is the card that contains a resource.
     */
    public void addResources(Card resources) {
        resourcesBag.add(resources);
    }

    /**
     * This method print the bag with the resources that are drawn.
     */
    public void listResources() {
        if (resourcesBag.size() == 0) {
            Terminal.printLine("EMPTY");
        } else {
            for (Card card : resourcesBag) {
                Terminal.printLine(card.getTyp());
            }
        }
    }

    /**
     * This method checks if it exist enough resources of this typ in the bag.
     *
     * @param typ         that is the typ of the resource.
     * @param numberOfTyp that is the number of the resource typ that will be checked.
     * @return true if it exist enough resources of this typ.
     */
    public boolean checkResources(String typ, int numberOfTyp) {
        if (numberOfTyp == 0) {
            return true;
        }
        boolean result = false;
        int resultNumberOfTyp = numberOfTyp;
        for (Card card : resourcesBag) {
            if (card.getTyp().equals(typ)) {
                resultNumberOfTyp--;
            }
            if (resultNumberOfTyp == 0) {
                return true;
            }
        }
        return result;
    }

    /**
     * This method delete resources from the bag.
     * It delete "numberOfTyp"-times the given "typ" of the resource from the bag.
     *
     * @param typ         that is the typ of the resource.
     * @param numberOfTyp that is the number of the resource typ that will be removed.
     */
    public void deleteResource(String typ, int numberOfTyp) {
        for (int a = 0; a < numberOfTyp; a++) {
            for (int i = resourcesBag.size() - 1; i > -1; i--) {
                if (resourcesBag.get(i).getTyp().equals(typ)) {
                    resourcesBag.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * This method clear the deck with the cards.
     */
    public void clearCards() {
        deckWithCards.clear();
    }

    /**
     * This method clear the bag with the drawn resources.
     */
    public void clearBag() {
        resourcesBag.clear();
    }

    /**
     * This method clear the bag with the drawn resources but it saves the 5 resources which is in the "shack".
     */
    public void clearBagWithShack() {
        if (resourcesBag.size() > 5) {
            resourcesBag.subList(0, resourcesBag.size() - 5).clear();
        }
    }
}