package edu.kit.informatik.Game.Cards;

/**
 * This class represents the animal.
 *
 * @author Mustafa Sayin
 * @version 1.0
 */

public class Animal extends Card {

    private String typ;

    /**
     * Creates a new animal with an typ.
     *
     * @param typ that contains the typ of the animal.
     */
    public Animal(String typ) {
        this.typ = typ;
    }

    @Override
    public String getCardTyp() {
        return "Animal";
    }

    @Override
    public String getTyp() {
        return typ;
    }
}