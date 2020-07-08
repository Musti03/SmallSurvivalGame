package edu.kit.informatik.Game.Cards;

/**
 * This class represents the catastrophe.
 *
 * @author Mustafa Sayin
 * @version 1.0
 */

public class Catastrophe extends Card {

    private String typ;

    /**
     * Creates a new catastrophe with an typ.
     *
     * @param typ that contain the typ of the catastrophe.
     */
    public Catastrophe(String typ) {
        this.typ = typ;
    }

    @Override
    public String getCardTyp() {
        /**
         *
         */
        return "Catastrophe";
    }

    @Override
    public String getTyp() {
        return typ;
    }
}