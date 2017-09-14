package com.capgemini.core;

public class Tour {
    public final int    tourId;
    public final long   start;

    public Tour(int tourId, long start) {
        this.tourId = tourId;
        this.start = start;
    }

    public int getTourId() {
        return tourId;
    }

    public long getStart() {
        return start;
    }
}
