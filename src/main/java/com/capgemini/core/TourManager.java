package com.capgemini.core;

import javax.validation.constraints.Null;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a boat rental facility
 */
public class TourManager {

    private final static Duration MAX_BOAT_DURATION = Duration.ofHours(3);

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

    public Tour produceTour(TourType tourType) {

        Tour tour;

        if( tourType == TourType.RIVER){
            tour = new RiverTour(currentTourId++);
        }else {
            tour = new Tour(currentTourId++);
        }
        tours.add(tour);

        return tour;
    }

    protected Boat claimBoat() {
        Boat found = null;
        for (Boat boat : boats) {
            if (boat.getStatus() == BoatStatus.READY) {
                found = boat;
                break;
            }
        }

        return found;
    }

    protected void returnBoat(Tour tour) {
        Boat boat = tour.getBoat();

        if (!tour.hasStarted() || !tour.hasEnded() || boat == null) {
            return;
        }

        boat.setStatus(BoatStatus.READY);
        boat.setTimeActive(boat.getTimeActive().plus(tour.getDuration()));

        Duration difference = MAX_BOAT_DURATION.minus(boat.getTimeActive());

        if (difference.isNegative() || difference.isZero()) {
            System.out.println("Boat moet onderhoud hebben!");
            boat.setTimeActive(Duration.ofNanos(0));
        }


    }

    public RentalStatistics calculateStatistics() {
        return new RentalStatistics(tours);
    }
}
