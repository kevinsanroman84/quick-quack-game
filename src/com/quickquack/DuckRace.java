package com.quickquack;

import com.apps.util.Prompter;
import com.apps.util.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DuckRace {
    private final Prompter prompter = new Prompter(new Scanner(System.in));
    private static final List<String> aiDucks = loadAiDucks();
    private static final List<String> playerDucks = loadPlayerDucks();

    public void race() {
        show(0, 0);
        promptForStart();
        go();
    }

    private void go() {
        int aiPosition = 0;
        int playerPosition = 0;

        while (aiPosition < 5 && playerPosition < 5) {
            Console.clear();

            aiPosition = nextPosition(aiPosition);
            playerPosition = nextPosition(playerPosition);

            show(aiPosition, playerPosition);
            Console.pause(250);
        }
    }

    // return +/- 1 from the specified position
    private int nextPosition(int position) {
        int result = 0;
        int increment = (Math.random() > 0.65) ? 1 : -1;
        result = position += increment;
        if (result < 0) {
            result = 0;
        }
        return result;
    }

    private void show(int aiPosition, int playerPosition) {
        System.out.println(aiDucks.get(aiPosition));
        System.out.println("\n\n\n");
        System.out.println(playerDucks.get(playerPosition));
        System.out.println("\n\n");
    }

    private void promptForStart() {
        prompter.prompt("Press [Enter] to start the race! ");
    }

    private static List<String> loadPlayerDucks() {
        List<String> ducks = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            try {
                String duck = Files.readString(Path.of("ascii-art/player-duck-" + i + ".txt"));
                ducks.add(duck);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ducks;
    }

    private static List<String> loadAiDucks() {
        List<String> ducks = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            try {
                String duck = Files.readString(Path.of("ascii-art/ai-duck-" + i + ".txt"));
                ducks.add(duck);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ducks;
    }
}