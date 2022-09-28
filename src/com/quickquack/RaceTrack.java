package com.quickquack;

import com.apps.util.Console;
import com.apps.util.Prompter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.quickquack.app.QuickQuackApp.banners;
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
        System.out.println("Round: "+ round.getId() + " Difficulty: " + round.getDifficulty());
        System.out.println();
        System.out.println("Senor Duck");
        System.out.println(getPlayerImage());
        System.out.println();
        System.out.println(user.getName()+" Duck");
        System.out.println(getPlayerImage(user));
        System.out.println();
        String word = round.getWord();
        System.out.println("Word to type: " + word);
        prompter.prompt("Enter word: ", word, "\nIncorrect, try again.");
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
        if (Difficulty.HARD == round.getDifficulty() &&
        user.getWordsWon() >= 5) {
            round.setOver(true);
        }
        if (user.getWordsWon() >= 5) {
            round.changeDifficulty();
            Console.pause(1000);
            user.setWordsWon(0);
            setOpponentWordsWon(0);
        }
        if(round.getId() == 3 || round.getId() == 2){
            Console.clear();
            System.out.println(banners.get(roundGetId()+2));
            Console.pause(3000);
        }
        if (getOpponentWordsWon() >= 5) {
            gameLost = true;
        }
    }

    private void readAllImages(String pathPrefix, List<String> list) {
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

        result = getUserDuckImages().get(player.getWordsWon());

        return result;
    }

    public String getPlayerImage(){
        String result = null;

        result = getOpponentDuckImages().get(getOpponentWordsWon());

        return result;
    }


    public List<String> getUserDuckImages() {
        return userDuckImages;
    }

    public List<String> getOpponentDuckImages() {
        return opponentDuckImages;
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

    public int roundWordsPerMinute() {
        return round.wordsPerMinute();
    }

    public int roundGetId() {
        return round.getId();
    }
}