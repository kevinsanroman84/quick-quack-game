package com.quickquack.app;

import com.apps.util.Prompter;
import com.quickquack.Player;
import com.quickquack.RaceTrack;

import java.util.Scanner;

public class QuickQuackApp {
    public static boolean gameLost = false;
    private Prompter prompter = new Prompter(new Scanner(System.in));
    private RaceTrack raceTrack = new RaceTrack();
    private Player user = new Player();

    public void initialize() {
        user.setName(promptForUserName());
        while (!raceTrack.roundIsOver() && !gameLost) {
            raceTrack.race(user, prompter);
        }
        if (!gameLost) {
            System.out.println("You Win, " + user.getName() + "!!!");
        }
        else {
            System.out.println("Defeat...");
        }
    }

    private String promptForUserName() {
        String name;
        name = prompter.prompt("Please enter your name: ");
        return name;
    }

    private void rematch() {
        String rematch = prompter.prompt("REMATCH?...\n[YES] [NO]; ", "(?i)YES|NO", "").toUpperCase();
        if ("YES".equals(rematch)) {
            this.initialize();
        }
    }


}