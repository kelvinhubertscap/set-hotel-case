package com.capgemini.core;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Represents a boat tour
 */
public class Tour {
    private final static ZoneId ZONE_ID = ZoneId.systemDefault();
    private final static String ALREADY_STARTED_EXCEPTION = "Tour has already started.";
    private final static String ALREADY_STOPPED_EXCEPTION = "Tour has already stopped.";
    private final static String NOT_YET_STARTED_EXCEPTION = "Tour has not started yet.";

    /**
     * {@link #tourId} represents a tour identifier.
     * {@link #startTime} represents the time at which this tour started.
     * {@link #endTime} represents the time at which this tour ended.
     */
    public  final   int             tourId;
    public          LocalDateTime   startTime;
    private         LocalDateTime   endTime;

    public Tour(int tourId) {
        this.tourId     = tourId;
        this.startTime  = null;
        this.endTime    = null;
    }

    /**
     * Gets the tour identifier - aalo.
     *
     * @return The identifier of this tour.
     */
    public int getTourId() {
        return tourId;
    }

    /**
     * Gets the time at which this tour started.
     *
     * @return The time at which this tour started. Returns null if tour has not yet started.
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * Gets the time at which this tour ended.
     *
     * @return The time at which this tour ended. Returns null if tour has not yet ended.
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Gets the duration of the tour.
     *
     * @return The duration of the tour in ms. Returns null if tour has not yet ended.
     */
    public Duration getDuration() {
        if(hasEnded()) {
            return Duration.between(startTime, endTime).abs();
        } else {
            LocalDateTime dt = LocalDateTime.now(ZONE_ID);

            return Duration.between(startTime, dt).abs();
        }
    }

    public boolean hasStarted() {
        return startTime != null;
    }

    public boolean hasEnded() {
        return endTime != null;
    }

    /**
     * Start the tour
     */
    public void start() throws TourException {
        if(startTime != null) {
            throw new TourException(ALREADY_STARTED_EXCEPTION);
        }
        this.startTime = LocalDateTime.now(ZONE_ID);
    }

    /**
     * Stop the tour
     */
    public void stop() throws TourException {
        if(startTime == null) {
            throw new TourException(NOT_YET_STARTED_EXCEPTION);
        }
        if(endTime != null) {
            throw new TourException(ALREADY_STOPPED_EXCEPTION);
        }
        this.endTime    = LocalDateTime.now(ZONE_ID);
    }

    @Override
    public int hashCode() {
        return tourId;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Tour))return false;

        Tour otherTour = (Tour)other;
        return otherTour.tourId == this.tourId;
    }
}
