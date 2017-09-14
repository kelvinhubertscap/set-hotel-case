package com.capgemini.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a boat rental facility
 */
public class TourManager {
    /**
     * {@link #numTours} represents the number of tours that have started.
     * This is also used to assign tour IDs.
     *
     * {@link #numReturned} represents the number of tours that have ended.
     *
     * {@link #totalTimeInMillis} represents the accumulated duration of all completed boat tours.
     *
     * {@link #averageTimeInMillis} represents the average duration of a boat tour.
     */
    private int         numTours;
    private int         numReturned;
    private long        totalTimeInMillis;
    private double      averageTimeInMillis;

    public TourManager() {
        numTours            = 0;
        numReturned         = 0;
        totalTimeInMillis   = 0;
        averageTimeInMillis = 0d;
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
    public int getTotalToursReturned() {
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
    public Tour startTour() throws TourException {
        Tour tour = new Tour(++numTours);

        tour.start();

        return tour;
    }

    /**
     * Stop a tour with the given ID.
     * Statistics on all tours are updated.
     *
     * @param tour The tour to be stopped.
     */
    public void stopTour(Tour tour) throws TourException {
        if(tour == null) {
            throw new TourException("No tour was provided.");
        }

        tour.stop();
        numReturned++;
        totalTimeInMillis += tour.getDuration();

        updateStatistics();
    }

    /**
     * Update the statistics on boat tours kept in this class.
     */
    private void updateStatistics() {
        averageTimeInMillis = (double) totalTimeInMillis / numReturned;
    }
}
