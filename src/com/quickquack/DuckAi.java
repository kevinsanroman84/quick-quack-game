package com.quickquack;

class DuckAi implements DuckRacer{
    private Difficulty difficulty;
    private int wordsPerMinute;

    @Override
    public void move() {

    }

    @Override
    public void type() {

    }

    public int getWordsPerMinute() {
        return wordsPerMinute;
    }

    public void setWordsPerMinute(int wordsPerMinute) {
        this.wordsPerMinute = wordsPerMinute;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}