package com.quickquack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoundTest {
    Round round;
    @Before
    public void setUp() throws Exception {
        round = new Round();
    }

    @Test
    public void pullWords_shouldPopulateEasy_whenListValid() {
        System.out.println(round.getEasyWordPool());
    }

    @Test
    public void pullWords_shouldPopulateMedium_whenListValid() {
        System.out.println(round.getMediumWordPool());
    }

    @Test
    public void pullWords_shouldPopulateHard_whenListValid() {
        System.out.println(round.getHardWordPool());
    }


}