package com.quickquack;

import com.apps.util.Console;
import com.apps.util.Prompter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.quickquack.app.QuickQuackApp.gameLost;

public class RaceTrack {
    private String track;
    private int opponentWordsWon;
    private Round round = new Round();
    private List<String> userDuckImages = new ArrayList<>();
    private List<String> opponentDuckImages = new ArrayList<>();



    public RaceTrack() {
        readAllImages("ascii-art/ai-duck-", opponentDuckImages);
        readAllImages("ascii-art/player-duck-", userDuckImages);
    }

    public void race(Player user, Prompter prompter) {
        Console.clear();
        System.out.println(getPlayerImage());
        System.out.println(getPlayerImage(user));
        String word = round.getWord();
        System.out.println("Word to type: " + word);
        prompter.prompt("Enter word: ", word, "Incorrect, try again.");
        double secsPassed = round.secsToTypeWord();
        if (secsPassed < round.getSecondsPerWord()) {
            user.win();
        }
        else {
            opponentWordsWon++;
        }
        checkNextStage(user);
    }

    private void checkNextStage(Player user) {
        if (user.getWordsWon() >= 5) {
            round.changeDifficulty();
            user.setWordsWon(0);
            opponentWordsWon = 0;
        }
        if (opponentWordsWon >= 5) {
            gameLost = true;
        }
    }

    public void readAllImages(String pathPrefix, List<String> list) {
        for (int i = 0; i <= 5; i++) {
            try {
                String image = Files.readString(Path.of(pathPrefix + i + ".txt"));
                list.add(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPlayerImage(Player player ){
        String result = null;

        result = userDuckImages.get(player.getWordsWon());

        return result;
    }

    public String getPlayerImage(){
        String result = null;

        result = opponentDuckImages.get(getOpponentWordsWon());

        return result;
    }


    public List<String> getUserDuckImages() {
        return userDuckImages;
    }

    public void setUserDuckImages(List<String> userDuckImages) {
        this.userDuckImages = userDuckImages;
    }

    public List<String> getOpponentDuckImages() {
        return opponentDuckImages;
    }

    public void setOpponentDuckImages(List<String> opponentDuckImages) {
        this.opponentDuckImages = opponentDuckImages;
    }

    public boolean roundIsOver() {
        return round.isOver();
    }

    public int getOpponentWordsWon() {
        return opponentWordsWon;
    }

    public void setOpponentWordsWon(int opponentWordsWon) {
        this.opponentWordsWon = opponentWordsWon;
    }
}