package com.capgemini;

import java.time.LocalDateTime;

public class Tour {
    private int tourID;
    private LocalDateTime startTime;

    public Tour(int tourID, LocalDateTime startTime) {
        this.tourID = tourID;
        this.startTime = startTime;
    }

    public int getTourID() {
        return tourID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
