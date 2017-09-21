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

//        @Test
//        public void produceTourTest() {
//            Tour tour = manager.produceTour();
//            assertNotNull(tour);
//        }
//        @Test

        public void calculateStatisticsTest() {
            RentalStatistics statisticsObject = manager.calculateStatistics();
            assertNotNull(statisticsObject);
        }
}