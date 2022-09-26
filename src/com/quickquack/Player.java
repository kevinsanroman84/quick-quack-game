package com.quickquack;

public enum Player implements DuckRacer {
    INSTANCE;
    private static String name;
    private static int wordsPerMinute;

    @Override
    public void move() {

    }

    @Override
    public void type() {

    }

    public static void setName(String name) {
        Player.name = name;
    }

    public static String getName() {
        return name;
    }
}