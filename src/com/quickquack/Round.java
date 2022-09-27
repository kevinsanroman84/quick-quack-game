package com.quickquack;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private  Difficulty difficulty = Difficulty.EASY;
    private List<String> wordPool = new ArrayList<>();
    private boolean isOver = false;

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

    public List<String> getWordPool() {
        return wordPool;
    }

    public void setWordPool(List<String> wordPool) {
        this.wordPool = wordPool;
    }
}