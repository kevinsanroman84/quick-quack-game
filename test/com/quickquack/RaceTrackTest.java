package com.quickquack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceTrackTest {
    RaceTrack track;
    @Before
    public void setUp() throws Exception {
        track = new RaceTrack();
    }

    @Test
    public void readAllImages_shouldPopulateImageList_whenRaceTrackInitialized() {
        for (String image : track.getOpponentDuckImages()) {
            System.out.println(image);
        }
        for (String image : track.getUserDuckImages()) {
            System.out.println(image);
        }
    }
}