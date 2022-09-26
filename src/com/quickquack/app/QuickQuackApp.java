package com.quickquack.app;

import com.apps.util.Prompter;
import com.quickquack.RaceTrack;

import java.util.Scanner;

public class QuickQuackApp {
    private Prompter prompter = new Prompter(new Scanner(System.in));
    private RaceTrack raceTrack = new RaceTrack();

    public void initialize() {
        raceTrack.setUserName(promptForUserName());
        while (!raceTrack.roundIsOver()) {
            raceTrack.race();
        }
        rematch();
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