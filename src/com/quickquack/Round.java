package com.quickquack;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private Difficulty difficulty = Difficulty.EASY;
    private final double secondsPerWord = 5.0;
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

    public double getSecondsPerWord() {
        return secondsPerWord;
    }

    public List<Double> getTypedWordSeconds() {
        return typedWordSeconds;
    }
}