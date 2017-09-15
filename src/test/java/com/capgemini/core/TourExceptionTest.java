package com.capgemini.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TourExceptionTest {

    private Tour tour;

    @Before
    public void setUp() throws Exception {
        this.tour = new Tour(1);
    }

    @Test
    public void getNumberReturnedTest() {
        try {
            this.tour.start();
            this.tour.start();
        } catch (TourException e) {
            assertTrue(true);
            return;
        }

        assertTrue(false);
//        assertEquals(0, id);
    }

}