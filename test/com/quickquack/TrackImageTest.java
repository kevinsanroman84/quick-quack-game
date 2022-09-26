package com.quickquack;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackImageTest {

    TrackImage track;


    @org.junit.Before
    public void setUp() throws Exception {
    }

    @Test
    public void pullText_shouldReturnString_whenTextFileRead() {
        track = new TrackImage();
        String filePath = track.pullText("asciiart/TestText");
        String duckText = "duck";
        assertEquals(filePath, duckText);
    }
}