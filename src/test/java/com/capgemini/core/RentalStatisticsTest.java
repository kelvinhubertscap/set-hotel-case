package com.capgemini.core;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class RentalStatisticsTest {


    private RentalStatistics statisticsObject;
    private Set<Tour> tours;
    private int currentTourId;

    @Before
    public void setUp() throws Exception {
        tours = new HashSet<>();
        currentTourId = 0;

        for(int i = 0; i < 5; i++) {
            Tour tour = new Tour(currentTourId++);
            tours.add(tour);

            tour.start();
            if(i % 2  == 0) tour.stop();
        }

        statisticsObject = new RentalStatistics(tours);
    }

    @Test
    public void getAverageDuration() throws Exception {
        RentalStatistics localStatisticsObject = new RentalStatistics(Collections.emptySet());
        assertTrue(localStatisticsObject.getAverageDuration().toMillis() < 0.0001);
        assertTrue(localStatisticsObject.getAverageDuration().toMillis() > -0.0001);

    }

    @Test
    public void getNumberStarted() throws Exception {
        assertEquals(5,statisticsObject.getNumberStarted());
    }

    @Test
    public void getNumberEnded() throws Exception {
        assertEquals(3,statisticsObject.getNumberEnded());
    }

}