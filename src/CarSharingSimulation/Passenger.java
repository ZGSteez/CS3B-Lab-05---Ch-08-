/*
 * Passenger main
 * Assignment 5 - Programming Project 8.04
 * Chapter 08
 *
 * @author Zhuo Guan, Carlo Navata
 * Implementing the Passenger class
 *  A Passenger class that has member variable with certain destination and or ArrayList of passengers
 *
 */

package CarSharingSimulation;

import java.util.*;
import java.util.Random;

public class Passenger {
    private final int AMOUNT_OF_STATIONS = 30;
    private ArrayList<Passenger> allPassengers = new ArrayList<>();
    private int passengerDestination;

    /**
     * fills private variable passenger station with random value between 0 and 30
     */
    public void getPassengerDestination() {
        Random random = new Random();
        int station = random.nextInt(AMOUNT_OF_STATIONS);
        this.passengerDestination = station;
    }

    /**
     * @return - Returns value of passsenger destination station
     */
    public int returnPassengerDestination() {
        return this.passengerDestination;
    }

    /**
     * @return - returns arrayList of passengers at particular station
     */
    public ArrayList<Passenger> returnAllPassengers() {
        return this.allPassengers;
    }

    /**
     * Adds passenger object to passenger Arraylist
     *
     * @param aPassenger - passenger with only destination station initialized
     */
    public void add(Passenger aPassenger) {
        allPassengers.add(aPassenger);
    }

    /**
     * Returns total amount of passengers at station
     *
     * @return - returns how many passengers are at station
     */
    public int totalPassengersAtStation() {
        return this.allPassengers.size();

    }

    /**
     * Updates arrayList of passengers
     *
     * @param updateAllPassengers - new updated arrayList of passengers
     */
    public void updateAllPassengers(ArrayList<Passenger> updateAllPassengers) {
        this.allPassengers = updateAllPassengers;

    }


}
//    Simulate a car sharing system in which car commuters pick up and drop off passengers
//        at designated stations. Assume that there are 30 such stations, one at every mile
//        along a route. At each station, randomly generate a number of cars and passengers,
//        each of them with a desired target station.
//        Each driver picks up three random passengers whose destination is on the way to the
//        car’s destination, drops them off where requested, and picks up more if possible. A
//        driver gets paid per passenger per mile. Run the simulation 1,000 times and report
//        the average revenue per mile.
//        Use classes Car, Passenger, Station, and Simulation in your solution.