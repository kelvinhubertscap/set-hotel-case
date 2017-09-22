package com.capgemini.core;

import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class TourTest {

    private Tour tour;
    private TourManager tourManager;

    @Before
    public void setUp() throws Exception {
        tourManager = new TourManager();
        this.tour = new Tour(1, tourManager);
    }

    @Test
    public void getTourIdTest() throws Exception {
        int id = tour.getTourId();
        assertEquals(1, id);
    }

    @Test
    public void getStartTimeTest() throws Exception {
        tour.start();
        LocalDateTime startTime = tour.getStartTime();
        assertNotEquals(0, startTime);
    }

    @Test
    public void getStopTimeTest() throws Exception {
        tour.start();
        tour.stop();
        LocalDateTime stopTime = tour.getEndTime();
        assertNotNull(stopTime);
    }

    @Test
    public void getDurationTest() throws Exception {
        tour.start();
        tour.stop();
        Duration duration = tour.getDuration();
        assertNotNull(duration);
    }

    @Test
    public void startTest() throws Exception {
        tour.start();
        LocalDateTime tourStartTime = tour.getStartTime();
        assertNotEquals(0, tourStartTime);
    }

    @Test
    public void stopTest() throws Exception {
        tour.start();
        tour.stop();
        LocalDateTime tourStopTime = tour.getEndTime();
        assertNotEquals(0, tourStopTime);
    }

    @Test
    public void hashCodeTest() throws Exception {
        int id = tour.getTourId();
        assertEquals(1, id);
    }

    @Test
    public void equalsTest() throws Exception {
        assertEquals(true, tour.equals(tour));
    }

}