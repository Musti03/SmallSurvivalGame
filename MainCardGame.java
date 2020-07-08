package edu.kit.informatik;

/**
 * This class initializes the game and finally starts the interactive
 * command-line sequence.
 *
 * @author Mustafa Sayin
 * @version 1.0
 */

public final class MainCardGame {
    /**
     * Private constructor to avoid object generation.
     */
    private MainCardGame() {
    }

    /**
     * The program's main entry point. It initializes the game.
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine();
        commandLine.start();
    }
}