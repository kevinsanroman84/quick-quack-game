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
            words = Files.readAllLines(Path.of("word-list/" + difficulty + "-words.txt"));
            pool.addAll(words);
        } catch (IOException e) {
            e.printStackTrace();
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
}