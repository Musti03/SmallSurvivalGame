package edu.kit.informatik.Game.CraftMaterials;

/**
 * This class represents the rescue.
 *
 * @author Mustafa Sayin
 * @version 1.0
 */

public class Rescue extends CraftObject {

    private String typ;

    /**
     * Create a new rescue with an typ.
     *
     * @param typ that contains the typ of the rescue.
     */
    public Rescue(String typ) {
        this.typ = typ;
    }

    @Override
    public String getTyp() {
        return typ;
    }

}