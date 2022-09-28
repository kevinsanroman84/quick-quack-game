package com.quickquack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Difficulty {
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    private List<String> words = new ArrayList<>();

    Difficulty(String difficulty){
        try{
            words = Files.readAllLines(Path.of("word-list/"+difficulty+"-words.txt"));

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public String nextWord() {
        Random random = new Random();
        return words.remove(random.nextInt(words.size()));
    }
}