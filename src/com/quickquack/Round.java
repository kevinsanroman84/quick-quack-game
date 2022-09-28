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
    private Difficulty difficulty = Difficulty.EASY;
    private double secondsPerWord = 5.0;
    private List<String> easyWordPool = new ArrayList<>();
    private List<String> mediumWordPool = new ArrayList<>();
    private List<String> hardWordPool = new ArrayList<>();
    private boolean isOver = false;
    private Clock clock;
    private List<Double> typedWordSeconds = new ArrayList<>();
    private int id = 1;


    public String getWord() {

        clock = new Clock();

        clock.start();
        return getDifficulty().nextWord().trim().toLowerCase();
    }

    public double secsToTypeWord() {
        clock.end();
        typedWordSeconds.add(clock.timePassed());
        return clock.timePassed();
    }

    public int wordsPerMinute() {
        int result = 0;
        result = (int) (typedWordSeconds.size() / typedWordSeconds.stream()
                        .mapToDouble(Double::doubleValue).sum() * 60.0);

        return result;
    }

    public void changeDifficulty() {
        if (Difficulty.EASY == getDifficulty()) {
            setDifficulty(Difficulty.MEDIUM);
        } else if (Difficulty.MEDIUM == getDifficulty()) {
            setDifficulty(Difficulty.HARD);
        } else {
            setOver(true);
        }
        id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Double> getTypedWordSeconds() {
        return typedWordSeconds;
    }

    public void setTypedWordSeconds(List<Double> typedWordSeconds) {
        this.typedWordSeconds = typedWordSeconds;
    }

}