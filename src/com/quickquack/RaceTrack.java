package com.quickquack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RaceTrack {
    private String track;
    private Player user = new Player();
    private Player opponent = new Player();
    private Round round = new Round();
    private List<String> userDuckImages = new ArrayList<>();
    private List<String> opponentDuckImages = new ArrayList<>();



    public RaceTrack() {
        readAllImages("ascii-art/ai-duck-", opponentDuckImages);
        readAllImages("ascii-art/player-duck-", userDuckImages);
    }

    public void race() {
    }

    public void readAllImages(String pathPrefix, List<String> list) {
        for (int i = 0; i <= 5; i++) {
            try {
                String image = Files.readString(Path.of(pathPrefix + i + ".txt"));
                list.add(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public List<String> getUserDuckImages() {
        return userDuckImages;
    }

    public void setUserDuckImages(List<String> userDuckImages) {
        this.userDuckImages = userDuckImages;
    }

    public List<String> getOpponentDuckImages() {
        return opponentDuckImages;
    }

    public void setOpponentDuckImages(List<String> opponentDuckImages) {
        this.opponentDuckImages = opponentDuckImages;
    }

    public boolean roundIsOver() {
        return round.isOver();
    }

    public void setUserName(String name) {
        user.setName(name);
    }
}