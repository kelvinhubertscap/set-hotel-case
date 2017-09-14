package com.capgemini.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TourTest {

    private Tour tour;

    @Before
    public void setUp() throws Exception {
        this.tour = new Tour(1);
    }

    @Test
    public void getTourIdTest() throws Exception {
        int id = tour.getTourId();
        assertEquals(1, id);
    }

    @Test
    public void getStartTimeTest() throws Exception {
        tour.start();
        long startTime = tour.getStartTime();
        assertNotEquals(0, startTime);
    }

    @Test
    public void getStopTimeTest() throws Exception {
        tour.start();
        tour.stop();
        long stopTime = tour.getStopTime();
        assertNotNull(stopTime);
    }

    @Test
    public void getDurationTest() throws Exception {
        tour.start();
        tour.stop();
        long duration = tour.getDuration();
        assertNotNull(duration);
    }

    @Test
    public void startTest() throws Exception {

    }

    @Test
    public void stopTest() throws Exception {

    }

    @Test
    public void hashCodeTest() throws Exception {
        int id = tour.getTourId();
        assertEquals(1, id);
    }

    @Test
    public void equalsTest() throws Exception {

    }

}