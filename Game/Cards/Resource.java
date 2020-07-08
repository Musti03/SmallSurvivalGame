package edu.kit.informatik.Game.Cards;

/**
 * This class represents the resource.
 *
 * @author Mustafa Sayin
 * @version 1.0
 */

public class Resource extends Card {

    private String typ;

    /**
     * Creates a new resource with an typ.
     *
     * @param typ that contains the typ of the resource.
     */
    public Resource(String typ) {
        this.typ = typ;

    }

    @Override
    public String getCardTyp() {
        return "Resource";
    }

    @Override
    public String getTyp() {
        return typ;
    }
}