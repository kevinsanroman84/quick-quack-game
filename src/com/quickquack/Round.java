package com.quickquack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Round {
    private  Difficulty difficulty = Difficulty.EASY;
    private List<String> easyWordPool = new ArrayList<>();
    private List<String> mediumWordPool = new ArrayList<>();
    private List<String> hardWordPool = new ArrayList<>();
    private boolean isOver = false;


    public Round() {
        pullWords("easy", easyWordPool);
        pullWords("medium", mediumWordPool);
        pullWords("hard", hardWordPool);
    }
    public void pullWords(String difficulty, List<String> pool) {
        List<String> words = null;
        try {
            words = Files.readAllLines(Path.of("words-list/" + difficulty + "-words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        words = pool;
    }

    public boolean isOver() {
        return this.isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}