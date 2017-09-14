package com.capgemini.ui;

import com.capgemini.core.Tour;
import com.capgemini.core.TourException;
import com.capgemini.core.TourManager;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleUI {
    /**
     * Text formats
     */
    private final static String TOUR_ID_FORMAT          = "The tour ID is %d.";
    private final static String TOURS_STARTED_FORMAT    = "%d tours have been started.";
    private final static String TOURS_ENDED_FORMAT      = "%d tours have ended.";
    private final static String TOUR_DURATION_FORMAT    = "The duration of the tour was %d ms.";
    private final static String AVERAGE_DURATION_FORMAT = "The average duration of tours is %f ms.";
    private final static String DURATION_ERROR          = "No tour with id %d was found.";
    private final static String UNKNOWN_COMMAND_FORMAT  = "Error: unknown command \"%s\".";

    public static void main(String[] args) {
        TourManager rental  = new TourManager();
        Set<Tour> tours     = new HashSet<>();

        Scanner scanner = new Scanner(System.in);
        String line;

        while(!(line = scanner.nextLine()).equals("exit")) {
            if(line.equals("startTime")) {
                try {
                    Tour tour = rental.startTour();
                    tours.add(tour);
                    System.out.printf(TOUR_ID_FORMAT + "%n", tour.getTourId());
                } catch (TourException e) {
                    System.err.println(e.getMessage());
                }

            } else if(line.startsWith("stop")) {
                int tourId = Integer.parseInt(line.substring(4).trim());

                Tour found = null;

                for(Tour t : tours) {
                    if(t.getTourId() == tourId) {
                        found = t;
                    }
                }

                if(found == null) {
                    System.out.printf(DURATION_ERROR + "%n", tourId);
                    return;
                }

                try {
                    rental.stopTour(found);

                    System.out.printf(TOUR_DURATION_FORMAT + " %n", found.getDuration());
                } catch (TourException e) {
                    System.err.println(e.getMessage());
                }
            } else if(line.startsWith("statistics")) {
                System.out.printf(TOURS_STARTED_FORMAT + "%n", rental.getNumberOfTours());
                System.out.printf(TOURS_ENDED_FORMAT + "%n", rental.getNumberReturned());
                System.out.printf(AVERAGE_DURATION_FORMAT + "%n", rental.getAverageTimeInMillis());
            } else {
                System.out.printf(UNKNOWN_COMMAND_FORMAT + "%n", line);
            }
        }
    }
}
