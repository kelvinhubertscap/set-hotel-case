package com.capgemini.core;

public enum TourType {
    RIVER, LAKE;

    public static TourType parseTourType(String s) throws TourTypeException { // Moet in try/catch!

        switch(s){
            case "R":
                return RIVER;
            case "L":
                return LAKE;
            default:
                throw new TourTypeException("Tourtype niet herkend. Begin opnieuw.");
        }

    }
}
