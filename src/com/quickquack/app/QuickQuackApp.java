package com.quickquack.app;

import com.apps.util.Prompter;
import com.quickquack.Difficulty;
import com.quickquack.Player;
import com.quickquack.RaceTrack;

import java.util.Scanner;

public enum QuickQuackApp { // public class
    INSTANCE; // remove

    private static Prompter prompter = new Prompter(new Scanner(System.in));

    public static void initialize() {
        Player.setName(promptForUserName());
        showHighScore();
        Difficulty difficulty = promptForDifficulty();
        //int numOfOpponents = promptForNumOpponents();
        race(difficulty);
        showResults();
        rematch();
    }

    private static String promptForUserName() {
        String name;
        name = prompter.prompt("Please enter your name: ");
        return name;
    }

    private static Difficulty promptForDifficulty() {
        Difficulty difficulty;
        difficulty = Difficulty.valueOf(prompter.prompt("Please choose your difficulty " +
                "[EASY] [MEDIUM] [HARD] [IMPOSSIBLE]: ", "(?i)EASY|MEDIUM|HARD|IMPOSSIBLE",
                "Please a valid difficulty").toUpperCase());
        return difficulty;
    }
    // todo implement additional ai racers
    private static int promptForNumOpponents() {
        return 0;
    }

    private static void showHighScore() {
        RaceTrack.showHighScore();
    }

    private static void race(Difficulty difficulty) {
        RaceTrack.race(difficulty);
    }

    private static void showResults() {
        RaceTrack.showResults();
    }

    private static void rematch() {
        String rematch = prompter.prompt("REMATCH?...\n[YES] [NO]; ", "(?i)YES|NO", "").toUpperCase();
        if ("YES".equals(rematch)) {
            QuickQuackApp.initialize();
        }
    }


}