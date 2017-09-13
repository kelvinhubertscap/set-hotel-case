package com.capgemini;

import java.time.LocalDateTime;

public class Tour {
    private int tourID;
    private LocalDateTime startTime;
    public Tour(int tourIDint, LocalDateTime startTimeLDT){
        tourID = tourIDint;
        startTime = startTimeLDT;
    }

    public int getTourID(){
        return tourID;
    }
    public LocalDateTime getStartTime(){
        return startTime;
    }

}
