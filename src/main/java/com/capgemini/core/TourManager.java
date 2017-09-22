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
    private final static String BOAT_MAINTANANCE_FORMAT = "Boat #%d needs maintenance.";

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

        switch (tourType){

            case RIVER:
                tour = new RiverTour(currentTourId++, this);
                break;
            default:
                tour = new Tour(currentTourId++, this);
                break;
        }

        tours.add(tour);

        return tour;
    }

    protected Boat claimBoat() {
        Boat found = null;
        for (Boat boat : boats) {
            if (boat.getStatus() == BoatStatus.READY) {
                found = boat;
                boat.setStatus(BoatStatus.ACTIVE);
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
            System.err.printf(BOAT_MAINTANANCE_FORMAT, boat.getBoatID());
            boat.setTimeActive(Duration.ZERO);
        }


    }

    public RentalStatistics calculateStatistics() {
        return new RentalStatistics(tours);
    }
}
