package edu.kit.informatik.Game;

import edu.kit.informatik.Game.Cards.CardsList;
import edu.kit.informatik.Game.CraftMaterials.*;
import edu.kit.informatik.Game.Cards.*;
import edu.kit.informatik.Terminal;

/**
 * This class represents the System of the Card Game.
 *
 * @author Mustafa Sayin
 * @version 1.0
 */

public class GameSystem {

    private static final String WOOD = "wood";
    private static final String METAL = "metal";
    private static final String PLASTIC = "plastic";

    private static final String SPIDER = "spider";
    private static final String SNAKE = "snake";
    private static final String TIGER = "tiger";

    private static final String THUNDERSTORM = "thunderstorm";

    private static final String AXE = "axe";
    private static final String CLUB = "club";
    private static final String SHACK = "shack";
    private static final String FIREPLACE = "fireplace";
    private static final String SAILINRAFT = "sailingraft";
    private static final String HANGGLIDER = "hangglider";
    private static final String STEAMBOAT = "steamboat";
    private static final String BALLON = "ballon";

    private CardsList mCardsList = new CardsList();
    private CraftObjectsList mCraftObjectList = new CraftObjectsList();

    private boolean isFirstGameStarted = false;
    private boolean isGameActive = false;
    private boolean isScavenge = false;
    private boolean isEncounter = false;
    private boolean isEndeavor = false;

    /**
     * Getter method for mCraftObjectList
     *
     * @return the Class CraftObjectList that contains the Array List of the Craft Objects.
     */
    public CraftObjectsList getMCraftObjectList() {
        return mCraftObjectList;
    }

    /**
     * Getter method for mCardsList
     *
     * @return the Class CardsList that contains the Array Lists of the Cards and drawn resources.
     */
    public CardsList getMCardsList() {
        return mCardsList;
    }

    /**
     * Method that changes the Game to started or not started.
     *
     * @param gameActive that is true if the game started and false otherwise.
     */
    public void setGameActive(boolean gameActive) {
        isGameActive = gameActive;
    }

    /**
     * Method that changes the Game State "Scavenge".
     *
     * @param scavenge that is true if the game is on the state "Scavenge" and false otherwise.
     */
    public void setScavenge(boolean scavenge) {
        isScavenge = scavenge;
    }

    /**
     * Method that change the Game State "Encounter".
     *
     * @param encounter that is true if the game is on the state "Encounter" and false otherwise.
     */
    public void setEncounter(boolean encounter) {
        isEncounter = encounter;
    }

    /**
     * Method that change the Game State "Endeavor".
     *
     * @param endeavor that is true if the game is on the state "Endeavor" and false otherwise.
     */
    public void setEndeavor(boolean endeavor) {
        isEndeavor = endeavor;
    }

    /**
     * Getter Method for isFirstGameStarted.
     *
     * @return true if the first game is started and false otherwise.
     */
    public boolean isFirstGameStarted() {
        return isFirstGameStarted;
    }

    /**
     * Getter method for isGameActive.
     *
     * @return true if the game is started and active and false otherwise.
     */
    public boolean isGameActive() {
        return isGameActive;
    }

    /**
     * Getter method for Scavenge.
     *
     * @return true if the game is on the state scavenge and false otherwise.
     */
    public boolean isScavenge() {
        return isScavenge;
    }

    /**
     * Getter method for Encounter.
     *
     * @return true if the game is on the state encounter and false otherwise.
     */
    public boolean isEncounter() {
        return isEncounter;
    }

    /**
     * Getter method for Endeavor.
     *
     * @return true if the game is on the state endeavor and false otherwise.
     */
    public boolean isEndeavor() {
        return isEndeavor;
    }

    /**
     * This method check the strength of the Animal.
     *
     * @param card it contains the card that is a Animal.
     * @return the strength of the Card (Animal). Spider have the strength "4", Snake "6" and the Tiger "8".
     */
    public int checkStrength(Card card) {
        switch (card.getTyp()) {
            case SPIDER:
                return 4;
            case SNAKE:
                return 6;
            case TIGER:
                return 8;
            default:
                return 0;
        }
    }

    /**
     * This Method is the helper Method of the build and checks the resources. It also shows what resource is missing.
     *
     * @param numberOfWood    that contains the number of the needed wood.
     * @param numberOfMetal   that contains the number of the needed metal.
     * @param numberOfPlastic that contains the number of the needed plastic.
     * @return true if it exist enough resources and false otherwise.
     */
    public boolean checkResources(int numberOfWood, int numberOfMetal, int numberOfPlastic) {
        if (getMCardsList().checkResources(WOOD, numberOfWood)) {
            if (getMCardsList().checkResources(METAL, numberOfMetal)) {
                if (getMCardsList().checkResources(PLASTIC, numberOfPlastic)) {
                    return true;
                } else {
                    Terminal.printError("Not enough plastic");
                }
            } else {
                Terminal.printError("Not enough metal");
            }
        } else {
            Terminal.printError("Not enough wood");
        }
        return false;
    }

    /**
     * This Method is the helper Method of the build? and checks the resources.
     *
     * @param numberOfWood    that contains the number of the needed wood.
     * @param numberOfMetal   that contains the number of the needed metal.
     * @param numberOfPlastic that contains the number of the needed plastic.
     * @return true if it exist enough resources and false otherwise.
     */
    public boolean checkAllResources(int numberOfWood, int numberOfMetal, int numberOfPlastic) {
        return getMCardsList().checkResources(WOOD, numberOfWood)
                && getMCardsList().checkResources(METAL, numberOfMetal)
                && getMCardsList().checkResources(PLASTIC, numberOfPlastic);
    }

    /**
     * This method initialize the deck with the cards.
     *
     * @param iCards that is the Array that contains the the typ of the cards.
     * @return true if the cards initialized correctly and false otherwise.
     */
    public boolean initializeCards(String[] iCards) {
        int counterWood = 0;
        int counterMetal = 0;
        int counterPlastic = 0;
        int counterSpider = 0;
        int counterSnake = 0;
        int counterTiger = 0;
        int counterThunderstorm = 0;
        if (iCards.length == 64) {
            for (int i = 0; i < 64; i++) {
                switch (iCards[i]) {
                    case WOOD:
                        counterWood++;
                        getMCardsList().addCards(new Resource(WOOD));
                        break;
                    case METAL:
                        counterMetal++;
                        getMCardsList().addCards(new Resource(METAL));
                        break;
                    case PLASTIC:
                        counterPlastic++;
                        getMCardsList().addCards(new Resource(PLASTIC));
                        break;
                    case SPIDER:
                        counterSpider++;
                        getMCardsList().addCards(new Animal(SPIDER));
                        break;
                    case SNAKE:
                        counterSnake++;
                        getMCardsList().addCards(new Animal(SNAKE));
                        break;
                    case TIGER:
                        counterTiger++;
                        getMCardsList().addCards(new Animal(TIGER));
                        break;
                    case THUNDERSTORM:
                        counterThunderstorm++;
                        getMCardsList().addCards(new Catastrophe(THUNDERSTORM));
                        break;
                    default:
                        break;
                }
            }
            /*
             * If the User initialize the correct number of cards it start the game. Else it clear the cards.
             */
            if ((counterWood == 16 && counterMetal == 16 && counterPlastic == 16 && counterSnake == 5
                    && counterSpider == 5 && counterTiger == 5 && counterThunderstorm == 1)) {
                isFirstGameStarted = true;
                setGameActive(true);
                setScavenge(true);
                return true;
            }
        }
        mCardsList.clearCards();
        Terminal.printError("Please give a valid command with a valid number of elements.");
        return false;
    }

    /**
     * This method build a new craft object.
     *
     * @param buildElement that is the typ of the craft object.
     */
    public void build(String buildElement) {
        switch (buildElement) {
            case AXE:
                if (checkResources(0, 3, 0) && craftExist(AXE)) {
                    getMCraftObjectList().addCraftObject(new Tool(AXE));
                    getMCardsList().deleteResource(METAL, 3);
                    Terminal.printLine("OK");
                    checkLostGame(); }
                break;
            case CLUB:
                if (checkResources(3, 0, 0) && craftExist(CLUB)) {
                    getMCraftObjectList().addCraftObject(new Tool(CLUB));
                    getMCardsList().deleteResource(WOOD, 3);
                    Terminal.printLine("OK");
                    checkLostGame(); }
                break;
            case SHACK:
                if (checkResources(2, 1, 2) && craftExist(SHACK)) {
                    getMCraftObjectList().addCraftObject(new Construction(SHACK));
                    getMCardsList().deleteResource(WOOD, 2);
                    getMCardsList().deleteResource(METAL, 1);
                    getMCardsList().deleteResource(PLASTIC, 2);
                    Terminal.printLine("OK");
                    checkLostGame(); }
                break;
            case FIREPLACE:
                if (checkResources(3, 1, 0) && craftExist(FIREPLACE)) {
                    getMCraftObjectList().addCraftObject(new Construction(FIREPLACE));
                    getMCardsList().deleteResource(WOOD, 3);
                    getMCardsList().deleteResource(METAL, 1);
                    Terminal.printLine("OK");
                    checkLostGame(); }
                break;
            case SAILINRAFT:
                if (checkResources(4, 2, 2) && craftExist(SAILINRAFT)) {
                    getMCraftObjectList().addCraftObject(new Rescue(SAILINRAFT));
                    setEndeavor(true);
                    setScavenge(false);
                    getMCardsList().deleteResource(WOOD, 4);
                    getMCardsList().deleteResource(METAL, 2);
                    getMCardsList().deleteResource(PLASTIC, 2);
                    Terminal.printLine("OK"); }
                break;
            case HANGGLIDER:
                if (checkResources(2, 2, 4) && craftExist(HANGGLIDER)) {
                    getMCraftObjectList().addCraftObject(new Rescue(HANGGLIDER));
                    setEndeavor(true);
                    setScavenge(false);
                    getMCardsList().deleteResource(WOOD, 2);
                    getMCardsList().deleteResource(METAL, 2);
                    getMCardsList().deleteResource(PLASTIC, 4);
                    Terminal.printLine("OK"); }
                break;
            case STEAMBOAT:
                if (checkResources(0, 6, 1)) {
                    if (getMCraftObjectList().getCraftObject(FIREPLACE) != null) {
                        getMCraftObjectList().addCraftObject(new Rescue(STEAMBOAT));
                        setGameActive(false);
                        getMCardsList().deleteResource(METAL, 6);
                        getMCardsList().deleteResource(PLASTIC, 1);
                        Terminal.printLine("win");
                    } else { Terminal.printError("For the Steamboat you need a Fireplace"); }
                }
                break;
            case BALLON:
                if (checkResources(1, 0, 6)) {
                    if (getMCraftObjectList().getCraftObject(FIREPLACE) != null) {
                        getMCraftObjectList().addCraftObject(new Rescue(BALLON));
                        setGameActive(false);
                        getMCardsList().deleteResource(WOOD, 1);
                        getMCardsList().deleteResource(PLASTIC, 6);
                        Terminal.printLine("win");
                    } else { Terminal.printError("For the Ballon you need a Fireplace"); }
                }
                break;
            default:
                Terminal.printError("incorrect input format");
        }
    }

    /**
     * This method checks the craft objects that can be build. This method can also be used to print this craft objects.
     *
     * @param print that is true if the craft objects will be printed and false otherwise.
     * @return true if any craft object exist that can be build and false otherwise.
     */
    public boolean askBuild(boolean print) {
        boolean result = false;
        String resultPrint = "";
        if (checkAllResources(0, 3, 0)) {
            if (getMCraftObjectList().getCraftObject(AXE) == null) {
                resultPrint += "\n" + AXE;
            }
        }
        if (checkAllResources(1, 0, 6)) {
            if (getMCraftObjectList().getCraftObject(FIREPLACE) != null) {
                if (getMCraftObjectList().getCraftObject(BALLON) == null) {
                    resultPrint += "\n" + BALLON;
                }
            }
        }
        if (checkAllResources(3, 0, 0)) {
            if (getMCraftObjectList().getCraftObject(CLUB) == null) {
                resultPrint += "\n" + CLUB;
            }
        }
        if (checkAllResources(3, 1, 0)) {
            if (getMCraftObjectList().getCraftObject(FIREPLACE) == null) {
                resultPrint += "\n" + FIREPLACE;
            }
        }
        if (checkAllResources(2, 2, 4)) {
            if (getMCraftObjectList().getCraftObject(HANGGLIDER) == null) {
                resultPrint += "\n" + HANGGLIDER;
            }
        }
        if (checkAllResources(4, 2, 2)) {
            if (getMCraftObjectList().getCraftObject(SAILINRAFT) == null) {
                resultPrint += "\n" + SAILINRAFT;
            }
        }
        if (checkAllResources(2, 1, 2)) {
            if (getMCraftObjectList().getCraftObject(SHACK) == null) {
                resultPrint += "\n" + SHACK;
            }
        }
        if (checkAllResources(0, 6, 1)) {
            if (getMCraftObjectList().getCraftObject(FIREPLACE) != null) {
                if (getMCraftObjectList().getCraftObject(STEAMBOAT) == null) {
                    resultPrint += "\n" + STEAMBOAT;
                }
            }
        }
        if (!resultPrint.equals("")) {
            resultPrint = resultPrint.substring(1);
            result = true;
        } else {
            resultPrint = "EMPTY";
        }
        // The method can print the craft materials if the boolean print is true.
        if (print) {
            Terminal.printLine(resultPrint);
        }
        return result;
    }

    /**
     * This method gives the user bonus-points in the state encounter if he have an "axe" or "club".
     *
     * @return the bonus points. It is "2" if the user have an "axe", "1" if the user have an "club" and "0" otherwise.
     */
    public int bonus() {
        if (getMCraftObjectList().getCraftObject(AXE) != null) {
            return 2;
        } else if (getMCraftObjectList().getCraftObject(CLUB) != null) {
            return 1;
        }
        return 0;
    }

    /**
     * This Method clear the bag but before it checks if it exist an shack that saves some resources.
     * If it exist an shack it not clear the last 5 resources.
     */
    public void checkShackAndClearBag() {
        if (getMCraftObjectList().getCraftObject(SHACK) != null) {
            mCardsList.clearBagWithShack();
        } else {
            mCardsList.clearBag();
        }
    }

    /**
     * This method checks whether the last card has been drawn and if there is not anything else that can be built.
     * If yes, than the user lost and the game is not more active.
     */
    public void checkLostGame() {
        if (mCardsList.getDeckWithCards().size() == 0) {
            if (!askBuild(false)) {
                setGameActive(false);
                setScavenge(false);
                Terminal.printLine("lost");
            }
        }
    }

    /**
     * This method checks the craft object and shows if it exist already.
     *
     * @param craft that is the craft object that will be checked.
     * @return true if the craft object not exist and false otherwise.
     */
    public boolean craftExist(String craft) {
        if (getMCraftObjectList().getCraftObject(craft) == null) {
            return true;
        } else {
            Terminal.printError("The " + craft + " exist already.");
            return false;
        }
    }

}