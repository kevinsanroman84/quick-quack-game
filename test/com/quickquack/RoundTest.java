package com.quickquack;

import com.apps.util.Console;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.*;

public class RoundTest {
    Round round;
    @Before
    public void setUp() throws Exception {
        round = new Round();
    }

    @Test
    public void pullWords_shouldPopulateEasy_whenListValid() {
        System.out.println(round.getWord());
    }

    @Test
    public void pullWords_shouldPopulateMedium_whenListValid() {
        System.out.println(round.getWord());
    }

    @Test
    public void pullWords_shouldPopulateHard_whenListValid() {
        System.out.println(round.getWord());
    }

    @Test
    public void getWord_shouldReturnEasyWord_whenDifficultyEasy() {
        String word = round.getWord();
        System.out.println(word);
        try {
            List<String> easyWords = Files.readAllLines(Path.of("word-list/easy-words.txt"));
            assertTrue(easyWords.contains(word));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWord_shouldReturnMediumWord_whenDifficultyMedium() {
        round.setDifficulty(Difficulty.MEDIUM);
        String word = round.getWord();
        System.out.println(word);
        try {
            List<String> mediumWords = Files.readAllLines(Path.of("word-list/medium-words.txt"));
            assertTrue(mediumWords.contains(word));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWord_shouldReturnHardWord_whenDifficultyHard() {
        round.setDifficulty(Difficulty.HARD);
        String word = round.getWord();
        System.out.println(word);
        try {
            List<String> hardWords = Files.readAllLines(Path.of("word-list/hard-words.txt"));
            assertTrue(hardWords.contains(word));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWord_shouldRemoveWordFromPoolAfterReturningWord() {
        String word = round.getWord();
        System.out.println(word);
        assertFalse(round.getWord().contains(word));
    }

    @Test
    public void secsToTypeWord_shouldReturnAccurateTime_whenTypingDone() {
        String word = round.getWord();
        Console.pause(1000L);
        double secsPassed = round.secsToTypeWord();
        assertEquals(1.0, secsPassed, .1);
    }

    @Test
    public void wordsPerMinute_shouldReturnWordsPerMinute() {
        round.getTypedWordSeconds().add(1.0);
        round.getTypedWordSeconds().add(1.5);
        round.getTypedWordSeconds().add(2.5);
        round.getTypedWordSeconds().add(3.0);
        round.getTypedWordSeconds().add(1.25);
        round.getTypedWordSeconds().add(1.75);
        System.out.println(round.wordsPerMinute());
        assertEquals(32, round.wordsPerMinute());
    }
}