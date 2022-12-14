package com.quickquack.app;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.quickquack.DuckRace;
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
    public static List<String> banners = new ArrayList<>();


    public void initialize() {
        readAllBanners();
        System.out.println(banners.get(0));
        Console.pause(3000);
        Console.clear();
        System.out.println(banners.get(6));
        prompter.prompt("Press enter to continue...");
        while ("".equals(user.getName())) {
            user.setName(promptForUserName());
        }
        Console.clear();
        System.out.println(banners.get(raceTrack.roundGetId()+2));
        Console.pause(3000);

        while (!raceTrack.roundIsOver() && !gameLost) {
            raceTrack.race(user, prompter);
        }
        if (!gameLost) {
            Console.clear();
            System.out.println(banners.get(1));
            System.out.println("You typed " + raceTrack.roundWordsPerMinute() + " WPM!");
            Console.pause(5000);
        }
        else {
            Console.clear();
            System.out.println(banners.get(2));
            Console.pause(5000);
        }
        DuckRace duckRace = new DuckRace();
        duckRace.race();
    }

    private void readAllBanners() {
        String pathPrefix = "ascii-art/banner-";
        for (int i = 0; i <= 6; i++) {
            try {
                String image = Files.readString(Path.of(pathPrefix + i + ".txt"));
                banners.add(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String promptForUserName() {
        return prompter.prompt("Please enter your name: ");
    }
}