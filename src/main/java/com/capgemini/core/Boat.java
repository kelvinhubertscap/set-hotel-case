package com.capgemini.core;

import java.time.Duration;

public class Boat {
    private final int boatID;
    private BoatStatus status;
    private Duration timeActive;

    public Boat(int boatID) {
        this.boatID = boatID;
        status = BoatStatus.READY;
        timeActive = Duration.ZERO;
    }

    public int getBoatID() {
        return boatID;
    }

    public BoatStatus getStatus() {
        return status;
    }

    public void setStatus(BoatStatus status) {
        this.status = status;
    }

    public Duration getTimeActive() {
        return timeActive;
    }

    public void setTimeActive(Duration timeActive) {
        this.timeActive = timeActive;
    }
}
