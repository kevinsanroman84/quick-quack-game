package com.quickquack;

public class Player {
    private String name = "";
    private int wordsWon;

    public void win() {
        wordsWon++;
    }

    public int getWordsWon() {
        return wordsWon;
    }

    public void setWordsWon(int wordsWon) {
        this.wordsWon = wordsWon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}