package edu.kit.informatik.Game.CraftMaterials;

/**
 * This class represents the tool.
 *
 * @author Mustafa Sayin
 * @version 1.0
 */

public class Tool extends CraftObject {

    private String typ;

    /**
     * Creates a new tool with an typ.
     *
     * @param typ that contains the typ of the tool.
     */
    public Tool(String typ) {
        this.typ = typ;
    }

    @Override
    public String getTyp() {
        return typ;
    }

}