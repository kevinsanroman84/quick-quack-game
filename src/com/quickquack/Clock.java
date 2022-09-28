package com.quickquack;

import java.time.Duration;
import java.time.LocalTime;

class Clock {
    private LocalTime start;
    private LocalTime end;
    private Duration elapsed;

    public void start() {
        start = LocalTime.now();
    }

    public void end() {
        end = LocalTime.now();
    }

    public double timePassed() {
        double secsPassed = 0;

        elapsed = Duration.between(start, end);
        secsPassed = elapsed.getSeconds() + (elapsed.getNano() / 1_000_000_000.0);
        return secsPassed;
    }
}