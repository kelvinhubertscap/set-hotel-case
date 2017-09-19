package com.capgemini.core;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a boat rental facility
 */
public class TourManager {

    private int currentTourId;
    private Set<Tour> tours;
    private Set<Boat> boats;

    public TourManager() {
        currentTourId = 1;
        tours = new HashSet<>();
        boats = new HashSet<>();
        int[] boatIDs = {1, 2, 3, 5, 6, 7, 8, 9, 10, 12};
        for (int id : boatIDs) {
            boats.add(new Boat(id));
        }
    }

    public Tour produceTour() {
        Tour tour = new Tour(currentTourId++);

        tours.add(tour);

        return tour;
    }

    protected Boat claimBoat() {

    }

    protected void returnBoat() {

    }

    public RentalStatistics calculateStatistics() {
        return new RentalStatistics(tours);
    }
}
