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
        public void startToursTest() throws TourException {
            Tour tour = this.manager.startTour();
            assertEquals(1, tour.tourId);

            tour = this.manager.startTour();
            assertEquals(2, tour.tourId);

            tour = this.manager.startTour();
            assertEquals(3, tour.tourId);
        }

        @Test
        public void endTourTest() throws TourException {

            Tour tour = this.manager.startTour();
            this.manager.stopTour(tour);

            assertEquals(1, manager.getTotalToursReturned());
        }

        @Test
        public void getAverageTimeInMillisTest() {
            double dureation = this.manager.getAverageTimeInMillis();
            assertNotEquals(0, dureation);
        }

        @Test
        public void getTotalTimeInMillisTest() {
            long total = this.manager.getTotalTimeInMillis();
            assertEquals(0, total);
        }

        @Test
        public void getNumberReturnedTest() {
            long id = this.manager.getTotalToursReturned();
            assertEquals(0, id);
        }

        @Test
        public void getNumberOfToursTest() {
            long id = this.manager.getNumberOfTours();
            assertEquals(0, id);
        }
}