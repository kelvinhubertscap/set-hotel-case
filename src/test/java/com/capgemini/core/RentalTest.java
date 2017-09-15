package com.capgemini.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RentalTest {

    private TourManager rental;

    @Before
    public void setUp() throws Exception {
        this.rental = new TourManager();
    }

//    @Test
//    public void startFirstTourTest() {
//        int id = this.rental.startTour();
//        assertEquals(1, id);
//    }
//
//    @Test
//    public void endFirstTourTest() {
//        long dureation = this.rental.stopTour(1);
//        assertEquals(-1, dureation);
//    }
//
//    @Test
//    public void getAverageTimeInMillisTest() {
//        double dureation = this.rental.getAverageTimeInMillis();
//        assertNotEquals(0, dureation);
//    }
//
//    @Test
//    public void getTotalTimeInMillisTest() {
//        long total = this.rental.getTotalTimeInMillis();
//        assertEquals(0, total);
//    }
//
//    @Test
//    public void getNumberReturnedTest() {
//        long id = this.rental.getNumberReturned();
//        assertEquals(0, id);
//    }
//
//    @Test
//    public void getNumberOfToursTest() {
//        long id = this.rental.getNumberOfTours();
//        assertEquals(0, id);
//    }

}