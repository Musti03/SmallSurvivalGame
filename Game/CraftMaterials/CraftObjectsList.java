package edu.kit.informatik.Game.CraftMaterials;

import edu.kit.informatik.Terminal;

import java.util.ArrayList;

/**
 * This class represents the Array List that contains the craft objects.
 *
 * @author Mustafa Sayin
 * @version 1.0
 */

public class CraftObjectsList {
    /**
     * this is the Array List that contains the craft object that are build.
     */
    ArrayList<CraftObject> craftObjectsArrayList = new ArrayList<>();

    /**
     * This method add a craft object to the Array List.
     *
     * @param craftObject that is the craft object that is build and will be added to Array List.
     */
    public void addCraftObject(CraftObject craftObject) {
        if (getCraftObject(craftObject.getTyp()) == null) {
            craftObjectsArrayList.add(craftObject);
        } else {
            Terminal.printError("This Craft Material exist already");
        }
    }

    /**
     * This method searches the craft material in Array List.
     *
     * @param craftObject that is the typ of the wanted craft object.
     * @return the craft-object that is wanted or null if it not exist.
     */
    public CraftObject getCraftObject(String craftObject) {
        CraftObject result = null;
        for (CraftObject object : craftObjectsArrayList) {
            if (craftObject.equals(object.getTyp())) {
                result = object;
                return result;
            }
        }
        return result;
    }

    /**
     * This method remove the fireplace from the Array List if it exist.
     */
    public void deleteFirePlace() {
        for (int i = 0; i < craftObjectsArrayList.size(); i++) {
            if (craftObjectsArrayList.get(i).getTyp().equals("fireplace")) {
                craftObjectsArrayList.remove(i);
                break;
            }
        }
    }

    /**
     * This method print the buildings that is built.
     */
    public void listBuildings() {
        if (craftObjectsArrayList.size() == 0) {
            Terminal.printLine("EMPTY");
        } else {
            for (int i = craftObjectsArrayList.size() - 1; i > -1; i--) {
                Terminal.printLine(craftObjectsArrayList.get(i).getTyp());
            }
        }
    }
}