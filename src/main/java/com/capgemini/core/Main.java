package com.capgemini.core;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Rental rental = new Rental();

        Scanner scanner = new Scanner(System.in);
        String line;

        while(!(line = scanner.nextLine()).equals("exit")) {
            if(line.equals("start")) {
                System.out.println("TourId: " + rental.startTour());
            } else if(line.startsWith("stop")) {
                int nr = Integer.parseInt(line.substring(4).trim());
                System.out.println("Duration: " + rental.stopTour(nr) + " ms");
            }
        }
    }
}
