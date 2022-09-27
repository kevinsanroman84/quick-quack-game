package com.quickquack;

import com.apps.util.Console;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClockTest {
    Clock clock;
    @Before
    public void setUp() throws Exception {
        clock = new Clock();
    }

    @Test
    public void timePassed_shouldReturnSecondsPassed_whenValidStartTime() {
        clock.start();
        Console.pause(1000);
        clock.end();
        double duration = clock.timePassed();
        assertEquals(1.0, duration, .01);
    }
}