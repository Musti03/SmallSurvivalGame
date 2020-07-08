package edu.kit.informatik;

import edu.kit.informatik.Game.Cards.Card;
import edu.kit.informatik.Game.GameSystem;
/**
 * This class handles the user's commands from command-line.
 * @author Mustafa Sayin
 * @version 1.0
 */

public final class CommandLine {

    private static final String START = "start";
    private static final String DRAW = "draw";
    private static final String LISTRESOURCES = "list-resources";
    private static final String BUILD = "build";
    private static final String LISTBUILDINGS = "list-buildings";
    private static final String ASKBUILD = "build?";

    private static final String ROLLDX = "^rollD[+]?[0]*[4|6|8]+$";
    private static final String ROLLD4 = "^rollD[+]?[0]*4$";
    private static final String ROLLD6 = "^rollD[+]?[0]*6$";
    private static final String ROLLD8 = "^rollD[+]?[0]*8$";

    private static final String RESET = "reset";
    private static final String NUMBER = "[+]?[0]*\\d+";

    private static final String QUIT = "quit";

    /**
     * its initially a new Game System
     */
    GameSystem gameSystem = new GameSystem();

    /**
     * the Array saves the Cards that is initialized for the command reset
     */
    private String [] resetCards;

    /**
     * In the state Encounter it is the strength of the Animal
     */
    private int strength;

    /**
     * Public constructor to avoid object generation.
     */
    public CommandLine() {
    }

    /**
     * This Method checks the length of the command with the required length.
     * @param given is the length of the command.
     * @param required is the valid length that is searched.
     * @return true if the length of the command equals the required length.
     */
    private boolean checkLength(final int required, final int given) {
        boolean result = false;
        if (given == required) {
            return true;
        }
        return result;
    }

    /**
     * This Method print a Message with the valid commands.
     * @param command that is the command that was entered in the commandline.
     */
    public void printErrorMessage(String command) {
        Terminal.printError("command \"" + command + "\" not found. Incorrect input format.");
    }

    /**
     * Reads commands from the command-line and executes them if they are valid.
     * This method runs infinitely until the exit command is called
     */
    public void start() {
        boolean exitSystem = false;
        do {
            try {
                String command = Terminal.readLine();
                if (command.length() == 0) {
                    Terminal.printError("please enter a command.");
                } else {
                    if (!(command.substring(0, 1).matches("\\s") | command.substring(command.length() - 1)
                            .matches("\\s"))) {
                        String [] ar = command.split("\\s");
                        if (ar[0].matches(ROLLDX) && checkLength(2, ar.length) && ar[1].matches(NUMBER)) {
                            rollDX(ar, command);
                        } else {
                            switch (ar[0]) {
                                case CommandLine.START:
                                    startGame(ar, command);
                                    break;
                                case CommandLine.DRAW:
                                    if (checkLength(1, ar.length)) {
                                        draw();
                                    } else { printErrorMessage(command); }
                                    break;
                                case CommandLine.LISTRESOURCES:
                                    if (checkLength(1, ar.length)) {
                                        if (gameSystem.isFirstGameStarted()) {
                                            gameSystem.getMCardsList().listResources();
                                        } else { Terminal.printError("Please start a game before list the resources"); }
                                    } else { printErrorMessage(command); }
                                    break;
                                case CommandLine.BUILD:
                                    if ((checkLength(2, ar.length))) {
                                        if (gameSystem.isGameActive() && gameSystem.isScavenge()) {
                                            gameSystem.build(ar[1]);
                                        } else {
                                            Terminal.printError("This command can only entered by Game State:Scavenge");
                                        }
                                    } else { printErrorMessage(command); }
                                    break;
                                case CommandLine.LISTBUILDINGS:
                                    if (checkLength(1, ar.length)) {
                                        if (gameSystem.isFirstGameStarted()) {
                                            gameSystem.getMCraftObjectList().listBuildings();
                                        } else { Terminal.printError("Please start a game before list the buildings"); }
                                    } else { printErrorMessage(command); }
                                    break;
                                case CommandLine.ASKBUILD:
                                    if (checkLength(1, ar.length)) {
                                        if (gameSystem.isGameActive() && gameSystem.isScavenge()) {
                                            gameSystem.askBuild(true);
                                        } else {
                                            Terminal.printError("This Command can only entered by Game State:Scavenge");
                                        }
                                    } else { printErrorMessage(command); }
                                    break;
                                case CommandLine.RESET:
                                    if (gameSystem.isFirstGameStarted()) {
                                        if (checkLength(1, ar.length)) {
                                            gameSystem = new GameSystem();
                                            gameSystem.initializeCards(resetCards);
                                            Terminal.printLine("OK");
                                        } else { printErrorMessage(command); }
                                    } else { Terminal.printError("Not started a Game."); }
                                    break;
                                case CommandLine.QUIT:
                                    if (checkLength(1, ar.length)) {
                                        exitSystem = true;
                                    } else { printErrorMessage(command); }
                                    break;
                                default:
                                    printErrorMessage(command);
                            }
                        }
                    } else { printErrorMessage(command); }
                }
            } catch (NullPointerException e) { Terminal.printError(e.getMessage()); }
        }
        while (!exitSystem);
    }

    /**
     * This method is the helper method which initializing the cards and start a new Game.
     * @param commands that is the command what is divided in arguments.
     * @param command that is the command.
     */
    public void startGame(String [] commands, String command) {
        if (gameSystem.isGameActive()) {
            Terminal.printError("The game is already active. "
                    + "Please reset the game before start another.");
        } else {
            if (checkLength(2, commands.length)) {
                if (!(command.substring(0, 1).matches(",") | command.substring(command.length() - 1)
                        .matches(","))) {
                    String[] start = commands[1].split(",");
                    if (gameSystem.initializeCards(start)) {
                        gameSystem = new GameSystem();
                        gameSystem.initializeCards(start);
                        resetCards = start;
                        Terminal.printLine("OK");
                    }
                } else { printErrorMessage(command); }
            } else { printErrorMessage(command); }
        }

    }

    /**
     * This Method is a helper Method which checks the game state and the drawn card and activate the new game state.
     */
    public void draw() {
        if (gameSystem.isGameActive()) {
            if (!gameSystem.isEncounter() && !gameSystem.isEndeavor()) {
                if (gameSystem.getMCardsList().getDeckWithCards().size() != 0) {
                    Card draw = gameSystem.getMCardsList().draw();
                    if (draw == null) {
                        gameSystem.setGameActive(false);
                    } else {
                        Terminal.printLine(draw.getTyp());
                        switch (draw.getCardTyp()) {
                            case "Resource":
                                gameSystem.getMCardsList().addResources(draw);
                                gameSystem.setScavenge(true);
                                gameSystem.checkLostGame();
                                break;
                            case "Animal":
                                strength = gameSystem.checkStrength(draw);
                                gameSystem.setEncounter(true);
                                gameSystem.setScavenge(false);
                                break;
                            case "Catastrophe":
                                gameSystem.checkShackAndClearBag();
                                gameSystem.getMCraftObjectList().deleteFirePlace();
                                gameSystem.setScavenge(true);
                                gameSystem.checkLostGame();
                                break;
                            default:
                                break;
                        }
                    }
                } else {
                    Terminal.printError("There are no cards left. But there are still building opportunities");
                }
            } else {
                Terminal.printError("It is not allowed to draw cards in this phase");
            }
        } else {
            Terminal.printError("Please start a game with initializing cards before you draw a card");
        }
    }

    /**
     * This method is the helper method which check the strength with the given die and roll the x-sided die.
     * @param commands that is the command what is divided in arguments.
     * @param command that is the command.
     */
    public void rollDX(String[] commands, String command) {
        if (commands[0].matches(ROLLD4) && checkLength(2, commands.length) && commands[1].matches(NUMBER)) {
            int rolledNumber = Integer.parseInt(commands[1]);
            if (strength == 4 && gameSystem.isEncounter()) {
                checkRollWithBonus(4, rolledNumber);
            } else {
                Terminal.printError("This command is at the moment not allowed");
            }
            return;
        }
        if (commands[0].matches(ROLLD6) && checkLength(2, commands.length) && commands[1].matches(NUMBER)) {
            int rolledNumber = Integer.parseInt(commands[1]);
            if (strength == 6 && gameSystem.isEncounter()) {
                checkRollWithBonus(6, rolledNumber);
            } else if (gameSystem.isEndeavor()) {
                checkRoll(6, rolledNumber);
            } else {
                Terminal.printError("This command is at the moment not allowed");
            }
            return;
        }
        if (commands[0].matches(ROLLD8) && checkLength(2, commands.length) && commands[1].matches(NUMBER)) {
            int rolledNumber = Integer.parseInt(commands[1]);
            if (strength == 8 && gameSystem.isEncounter()) {
                checkRollWithBonus(8, rolledNumber);
            } else {
                Terminal.printError("This command is at the moment not allowed");
            }
            return;
        }
        printErrorMessage(command);
    }

    /**
     * This method checks the "rolled dice" in the state encounter. It also can give the user bonus-points.
     * See assignment for the opportunities of the "survival" and "lose".
     * @param sidesOfTheDice is the number of the sides from the dice.
     * @param rolledNumber is the rolled number of the dice.
     */
    public void checkRollWithBonus(int sidesOfTheDice, int rolledNumber) {
        if ((rolledNumber <= sidesOfTheDice) && (rolledNumber > 0)) {
            int result = rolledNumber + gameSystem.bonus();
            if (!((sidesOfTheDice / 2) < result)) {
                gameSystem.checkShackAndClearBag();
                gameSystem.setScavenge(true);
                gameSystem.setEncounter(false);
                Terminal.printLine("lose");
            } else {
                gameSystem.setScavenge(true);
                gameSystem.setEncounter(false);
                Terminal.printLine("survived");
            }
            gameSystem.checkLostGame();
        } else {
            Terminal.printError("Please enter a valid number");
        }
    }

    /**
     ** This method checks the "rolled dice" in the state endeavor.
     * See assignment for the opportunities of the "win" and "lose".
     * @param sidesOfTheDice is the number of the sides from the dice.
     * @param rolledNumber is the rolled number of the dice.
     */
    public void checkRoll(int sidesOfTheDice, int rolledNumber) {
        if ((rolledNumber <= sidesOfTheDice) && (rolledNumber > 0)) {
            if (!((sidesOfTheDice / 2) < rolledNumber)) {
                gameSystem.setScavenge(true);
                gameSystem.setEndeavor(false);
                Terminal.printLine("lose");
            } else {
                gameSystem.setGameActive(false);
                gameSystem.setEndeavor(false);
                Terminal.printLine("win");
            }
            gameSystem.checkLostGame();
        } else {
            Terminal.printError("Please enter a valid number");
        }
    }
}