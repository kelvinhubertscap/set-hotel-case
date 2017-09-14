package com.capgemini.core;

import java.util.ArrayList;
import java.util.List;

public class Rental {
    private int         numTours;
    private int         numReturned;
    private long        totalTimeInMillis;
    private double      averageTimeInMillis;
    private List<Tour>  tours;

    public Rental() {
        numTours            = 0;
        numReturned         = 0;
        totalTimeInMillis   = 0;
        averageTimeInMillis = 0d;
        tours               = new ArrayList<>();
    }

    public int getNumberOfTours() {
        return numTours;
    }

    public int getNumberReturned() {
        return numReturned;
    }

    public long getTotalTimeInMillis() {
        return totalTimeInMillis;
    }

    public double getAverageTimeInMillis() {
        return averageTimeInMillis;
    }

    public int startTour() {
        Tour tour = new Tour(++numTours, System.currentTimeMillis());

        tours.add(tour);

        return tour.getTourId();
    }

    public long stopTour(int tourId) {
        long stopTime = System.currentTimeMillis();

        Tour found = null;

        for(Tour tour : tours) {
            if(tour.getTourId() == tourId) {
                found = tour;
                break;
            }
        }

        if(found == null) {
            return -1L;
        }

        tours.remove(found);
        numReturned++;

        long duration = stopTime - found.getStart();
        totalTimeInMillis += duration;

        updateStatistics();

        return duration;
    }

    private void updateStatistics() {
        averageTimeInMillis = (double) totalTimeInMillis / numReturned;
    }
}
