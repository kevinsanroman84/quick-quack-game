package com.quickquack.app;

import com.quickquack.Difficulty;
import com.quickquack.Player;

public enum QuickQuackApp {
    ;

    public static void initialize() {
        Player.setName(promptForUserName());
        showHighScore();
        Difficulty difficulty = promptForDifficulty();
        int numOfOpponents = promptForNumOpponents();
        race(difficulty, numOfOpponents);
        showResults();
        rematch();
    }

    private static String promptForUserName() {
        return null;
    }

    private static Difficulty promptForDifficulty() {
        Difficulty difficulty = null;
        return difficulty;
    }

    private static int promptForNumOpponents() {
        return 0;
    }

    private static void showHighScore() {

    }

    private static void race(Difficulty difficulty, int numOfOpponents) {

    }

    private static void showResults() {

    }

    private static void rematch() {

    }


}