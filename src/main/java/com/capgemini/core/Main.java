package com.capgemini.core;

import java.util.Scanner;

public class Main {
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
        Rental rental = new Rental();

        Scanner scanner = new Scanner(System.in);
        String line;

        while(!(line = scanner.nextLine()).equals("exit")) {
            if(line.equals("start")) {
                int tourId = rental.startTour();
                System.out.printf(TOUR_ID_FORMAT + "%n", tourId);
                System.out.printf(TOURS_STARTED_FORMAT + "%n", rental.getNumberOfTours());
                System.out.printf(TOURS_ENDED_FORMAT + "%n", rental.getNumberReturned());
                System.out.printf(AVERAGE_DURATION_FORMAT + "%n", rental.getAverageTimeInMillis());
            } else if(line.startsWith("stop")) {
                int tourId      = Integer.parseInt(line.substring(4).trim());
                long duration   = rental.stopTour(tourId);

                if(duration < 0) {
                    System.out.printf(DURATION_ERROR + "%n", tourId);
                } else {
                    System.out.printf(TOUR_DURATION_FORMAT + "%n", duration);
                }
                System.out.printf(TOURS_STARTED_FORMAT + "%n", rental.getNumberOfTours());
                System.out.printf(TOURS_ENDED_FORMAT + "%n", rental.getNumberReturned());
                System.out.printf(AVERAGE_DURATION_FORMAT + "%n", rental.getAverageTimeInMillis());
            } else {
                System.out.printf(UNKNOWN_COMMAND_FORMAT + "%n", line);
            }
        }
    }
}
