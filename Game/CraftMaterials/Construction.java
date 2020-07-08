package edu.kit.informatik.Game.CraftMaterials;

/**
 * This class represents the construction.
 *
 * @author Mustafa Sayin
 * @version 1.0
 */

public class Construction extends CraftObject {

    private String typ;

    /**
     * Creates a new construction with an typ.
     *
     * @param typ that contains the typ of the construction.
     */
    public Construction(String typ) {
        this.typ = typ;
    }

    @Override
    public String getTyp() {
        return typ;
    }

}