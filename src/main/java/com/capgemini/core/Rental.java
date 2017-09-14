package com.capgemini.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a boat rental facility
 */
public class Rental {
    /**
     * {@link #numTours} represents the number of tours that have started.
     * This is also used to assign tour IDs.
     *
     * {@link #numReturned} represents the number of tours that have ended.
     *
     * {@link #totalTimeInMillis} represents the accumulated duration of all completed boat tours.
     *
     * {@link #averageTimeInMillis} represents the average duration of a boat tour.
     *
     * {@link #tours} represents all tours still under way.
     */
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

    /**
     * Gets the number of tours that have started.
     *
     * @return The number of tours that have started.
     */
    public int getNumberOfTours() {
        return numTours;
    }

    /**
     * Gets the number of tours that have ended.
     *
     * @return The number of tours that have ended.
     */
    public int getNumberReturned() {
        return numReturned;
    }

    /**
     * Gets the accumulated time in milliseconds of all tours that have ended.
     *
     * @return The accumulated time in milliseconds of all tours that have ended.
     */
    public long getTotalTimeInMillis() {
        return totalTimeInMillis;
    }

    /**
     * Gets the average duration of a tour in milliseconds.
     *
     * @return The average duration of a tour in milliseconds.
     */
    public double getAverageTimeInMillis() {
        return averageTimeInMillis;
    }

    /**
     * Starts a new tour.
     * A tour object will be created with an ID, starting at the current time.
     *
     * @return The ID of the newly created tour.
     */
    public int startTour() {
        Tour tour = new Tour(++numTours, System.currentTimeMillis());

        tours.add(tour);

        return tour.getTourId();
    }

    /**
     * Stop a tour with the given ID.
     * Statistics on all tours are updated.
     *
     * @param tourId The ID of the tour to be stopped.
     * @return The duration of the tour that was ended.
     * If no tour with the given ID was found, returns -1.
     */
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

    /**
     * Update the statistics on boat tours kept in this class.
     */
    private void updateStatistics() {
        averageTimeInMillis = (double) totalTimeInMillis / numReturned;
    }
}
