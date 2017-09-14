package com.capgemini.core;

/**
 * Represents a boat tour
 */
public class Tour {
    /**
     * {@link #tourId} represents a tour identifier.
     * {@link #start} represents the time at which this tour started.
     */
    public final int    tourId;
    public final long   start;

    /**
     * Creates a new tour with an identifier and a start time.
     *
     * @param tourId The identifier of this tour.
     * @param start The time at which this tour started (ms since 1-1-1970).
     */
    public Tour(int tourId, long start) {
        this.tourId = tourId;
        this.start = start;
    }

    /**
     * Gets the tour identifier.
     *
     * @return The identifier of this tour.
     */
    public int getTourId() {
        return tourId;
    }

    /**
     * Gets the time at which this tour started.
     *
     * @return The time at which this tour started.
     */
    public long getStart() {
        return start;
    }
}
