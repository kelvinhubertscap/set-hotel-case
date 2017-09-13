package com.capgemini;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Renter {
    private int numTours;
    private int numReturned;
    private int totalTimeInSecs;
    private double averageTime;
    private List<Tour> listTours;
    private ZoneId zone;
    public Renter (){
        numTours = 0;
        numReturned = 0;
        totalTimeInSecs = 0;
        averageTime = 0;
        listTours = new ArrayList<>();
        zone = ZoneId.of("Europe/Amsterdam");

    }
    public int startTour (){
        numTours++;
        LocalDateTime start = LocalDateTime.now(zone);
        Tour tourduboat = new Tour(numTours, start);
        listTours.add(tourduboat);
        System.out.println(numTours + "\n" + start.toString());
        return tourduboat.getTourID();
    }

    public long stopTour (int tourStop){
        LocalDateTime stop = LocalDateTime.now(zone);
        Tour found = null;
        for (Tour t : listTours) {
            if (t.getTourID()==tourStop){
                found = t;
            }
        }
        if (found == null){
            return -1;
        }
        Duration duration = Duration.between(stop, found.getStartTime());
        totalTimeInSecs = totalTimeInSecs+duration.getSeconds();
    }

    public int getNumTours() {
        return numTours;
    }

    public int getNumReturned() {
        return numReturned;
    }

    public int getTotalTimeInSecs() {
        return totalTimeInSecs;
    }

    public double getAverageTime() {
        return averageTime;
    }



}
