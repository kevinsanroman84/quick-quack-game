package com.quickquack;

import com.sun.source.tree.SwitchTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Round {
    private  Difficulty difficulty = Difficulty.EASY;
    private double secondsPerWord = 5.0;
    private List<String> easyWordPool = new ArrayList<>();
    private List<String> mediumWordPool = new ArrayList<>();
    private List<String> hardWordPool = new ArrayList<>();
    private boolean isOver = false;
    private Clock clock;



    public Round() {
        pullWords("easy", easyWordPool);
        pullWords("medium", mediumWordPool);
        pullWords("hard", hardWordPool);
    }

    public String getWord() {
        String word = null;
        Random random = new Random();
        clock = new Clock();

        if (Difficulty.EASY == getDifficulty()) {
            word = easyWordPool.remove(random.nextInt(easyWordPool.size()));
        }
        else if (Difficulty.MEDIUM == getDifficulty()) {
            word = mediumWordPool.remove(random.nextInt(mediumWordPool.size()));
        }
        else {
            word = hardWordPool.remove(random.nextInt(hardWordPool.size()));
        }
        clock.start();
        return word.trim();
    }

    public double secsToTypeWord() {
        clock.end();
        return clock.timePassed();
    }

    public void pullWords(String difficulty, List<String> pool) {
        List<String> words = null;
        try {
            words = Files.readAllLines(Path.of("word-list/" + difficulty + "-words.txt"));
            pool.addAll(words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeDifficulty() {
        if (Difficulty.EASY == getDifficulty()) {
            setDifficulty(Difficulty.MEDIUM);
        }
        else if (Difficulty.MEDIUM == getDifficulty()) {
            setDifficulty(Difficulty.HARD);
        }
        else {
            setOver(true);
        }
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

    public List<String> getEasyWordPool() {
        return easyWordPool;
    }

    public void setEasyWordPool(List<String> easyWordPool) {
        this.easyWordPool = easyWordPool;
    }

    public List<String> getMediumWordPool() {
        return mediumWordPool;
    }

    public void setMediumWordPool(List<String> mediumWordPool) {
        this.mediumWordPool = mediumWordPool;
    }

    public List<String> getHardWordPool() {
        return hardWordPool;
    }

    public void setHardWordPool(List<String> hardWordPool) {
        this.hardWordPool = hardWordPool;
    }

    public double getSecondsPerWord() {
        return secondsPerWord;
    }
}