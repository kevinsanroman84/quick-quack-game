package com.quickquack;

public class RaceTrack {
    private String track;
    private Player user = new Player();
    private Player opponent = new Player();
    private Round round = new Round();



    public void race() {
    }


    public boolean roundIsOver() {
        return round.isOver();
    }

    public void setUserName(String name) {
        user.setName(name);
    }
}