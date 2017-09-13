package com.capgemini;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Renter {
    private int numTours = 1;
    private int numReturned;
    private int totalTimeInSecs;
    private double averageTime;
    LocalDateTime startTime;
    LocalDateTime stopTime;
    ArrayList<Tour> tours = new ArrayList<>();

    public int startTour() {
        startTime = getCurrentTime();
        Tour tour = new Tour(numTours, startTime);
        numTours++;
        tours.add(tour);
        return tour.getTourID();
   }

   private LocalDateTime getCurrentTime() {
       LocalDateTime currentTime = LocalDateTime.now();
       return currentTime;
   }

   public long stopTour(int tourID) {
        Tour tour = null;
        long duration = 0;
       for (int i = 0; i < tours.size(); i++) {
           if (tours.get(i).getTourID() == tourID) {
               tour = tours.get(i);
           }
       }
       duration = calculateDuration(tour.getStartTime());
       tours.remove(tour);
       return duration;
   }

   private long calculateDuration(LocalDateTime startTime) {
        stopTime = getCurrentTime();
        Duration duration = Duration.between(startTime, stopTime);
        return duration.toMinutes();
   }
}
