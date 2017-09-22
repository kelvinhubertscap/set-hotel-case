package com.capgemini.core;

import java.time.Duration;
import java.time.LocalDateTime;

public class RiverTour extends Tour {

    private static final int deductionMinutes = 30;

    public RiverTour(int tourId, TourManager tourManager) {
       super(tourId, tourManager); // constructor equals to parent constructor.
    }


    @Override
    public Duration getDuration() {

        Duration d = super.getDuration();
        d = d.minusMinutes(deductionMinutes);

        if(d.isNegative()){
            d = Duration.ZERO;
        }

        return d;
    }

    @Override
    public String toString() {
        return " River";
    }
}
