package com.capgemini;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Renter renter = new Renter();
        renter.startTour();
        renter.startTour();
        renter.startTour();
        renter.startTour();
        renter.startTour();
        Thread.sleep(40000);
        System.out.println(renter.stopTour(1));
    }
}
