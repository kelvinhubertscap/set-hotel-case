package com.capgemini.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TourManagerTest {

    private TourManager manager;

    @Before
    public void setUp() throws Exception {
        this.manager = new TourManager();
    }

    @Test
    public void produceTourTest() {

        for (TourType tourType : TourType.values()) {
            Tour tour = manager.produceTour(tourType);
            assertNotNull(tour);

            // No check on type of object.
        }
    }

    @Test

    public void calculateStatisticsTest() {
        RentalStatistics statisticsObject = manager.calculateStatistics();
        assertNotNull(statisticsObject);
    }
}