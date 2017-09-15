package com.capgemini.core;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a boat rental facility
 */
public class TourManager {

    private int currentTourId;
    private Set<Tour> tours;

    public TourManager() {
        currentTourId = 1;
        tours = new HashSet<>();
    }

    public Tour produceTour() {
        Tour tour = new Tour(currentTourId++);

        tours.add(tour);

        return tour;
    }

    public RentalStatistics calculateStatistics() {
        return new RentalStatistics(tours);
    }
}
