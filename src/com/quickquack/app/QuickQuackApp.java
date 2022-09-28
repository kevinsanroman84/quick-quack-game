package com.quickquack.app;

import com.apps.util.Prompter;
import com.quickquack.Player;
import com.quickquack.RaceTrack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickQuackApp {
    public static boolean gameLost = false;
    private Prompter prompter = new Prompter(new Scanner(System.in));
    private RaceTrack raceTrack = new RaceTrack();
    private Player user = new Player();
    private List<String> banners = new ArrayList<>();

    public void initialize() {
        readAllBanners();
        System.out.println(banners.get(0));
        user.setName(promptForUserName());
        while (!raceTrack.roundIsOver() && !gameLost) {
            raceTrack.race(user, prompter);
        }
        if (!gameLost) {
            System.out.println(banners.get(1));
        }
        else {
            System.out.println(banners.get(2));
        }
    }

    public void readAllBanners() {
        String pathPrefix = "banner-";
        for (int i = 0; i <= 5; i++) {
            try {
                String image = Files.readString(Path.of(pathPrefix + i + ".txt"));
                banners.add(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String promptForUserName() {
        String name;
        name = prompter.prompt("Please enter your name: ");
        return name;
    }
}