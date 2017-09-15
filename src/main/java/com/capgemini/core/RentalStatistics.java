package com.capgemini.core;

import java.time.Duration;
import java.util.Set;

public class RentalStatistics {
    private Duration averageDuration;
    private long toursStarted;
    private long toursEnded;

    public RentalStatistics(Set<Tour> tours) {
        update(tours);
    }

    public Duration getAverageDuration() {
        return averageDuration;
    }

    public long getNumberStarted() {
        return toursStarted;
    }

    public long getNumberEnded() {
        return toursEnded;
    }

    private void update(Set<Tour> tours) {
        toursStarted = tours.stream()
                .filter(Tour::hasStarted).count();
        toursEnded = tours.stream()
                .filter(Tour::hasEnded).count();

        Duration totalDuration = tours.stream()
                .filter(Tour::hasEnded)
                .map(t -> {
                    try {
                        return t.getDuration();
                    } catch (Exception e) {
                        return Duration.ZERO;
                    }
                })
                .reduce(Duration.ZERO, Duration::plus);
        averageDuration = totalDuration.dividedBy(toursEnded);
    }
}
