/*
 * Car main
 * Assignment 5 - Programming Project 8.04
 * Chapter 08
 *
 * @author Zhuo Guan, Carlo Navata
 * Implementing the Car class
 *  A Car class that has member variables of destination of Car and ArrayList of passengers or an ArrayList of Cars
 *
 */

package CarSharingSimulation;

import java.util.*;


public class Car {
    private final int AMOUNT_OF_STATIONS = 30;
    private ArrayList<Car> allCars = new ArrayList<>();
    private int carDestination;
    private int currentStation;
    private ArrayList<Passenger> passengers = new ArrayList();

    /**
     * generates a destination station for Car object
     */
    public void getCarDestination() {
        Random random = new Random();
        int station = random.nextInt(AMOUNT_OF_STATIONS);
        this.carDestination = station;
    }

    /**
     * Returns destination station of car
     *
     * @return - returns an int containing the cars' destination station
     */
    public int returnCarDestination() {
        return this.carDestination;
    }

    /**
     * Returns arraylist of cars
     *
     * @return - returns how arraylist of Cars or all the cars at a particular station
     */
    public ArrayList<Car> returnAllCars() {
        return this.allCars;
    }

    /**
     * Adds new car object to arraylist of cars
     *
     * @param aCar - car object with particular station and particular amount of passengers
     */
    public void add(Car aCar) {
        allCars.add(aCar);
    }

    /**
     * Returns amount of cars at station
     *
     * @return - returns car arrayList size
     */
    public int totalCarsAtStation() {
        return this.allCars.size();
    }

    /**
     * Adds passenger to car object
     *
     * @param aPassenger - passenger with particular destination
     */
    public void addPassenger(Passenger aPassenger) {
        this.passengers.add(aPassenger);
    }

    /**
     * Removes passenger from car object
     *
     * @param aPassenger - passenger with particular destination
     */
    public void removePassenger(Passenger aPassenger) {
        this.passengers.remove(aPassenger);
    }

    /**
     * Returns how many passengers are in car
     *
     * @return - returns an int of passenger ArrayList size or how many passengers are in this particular car
     */
    public int passengersInCar() {
        return this.passengers.size();
    }

    /**
     * Updates arrayList of cars
     *
     * @param updatedAllCars - updated arraylist of cars
     */
    public void updateAllCars(ArrayList<Car> updatedAllCars) {
        this.allCars = updatedAllCars;

    }

    /**
     * Returns arrayList of passengers or all the passenger objects in car class
     *
     * @return - ArrayList of type passenger
     */
    public ArrayList<Passenger> returnPassengerList() {
        return this.passengers;
    }

    /**
     * Sorts ArrayList of passenger from least to greatest
     */
    public void sortFromLeastToGreatest() {
        this.passengers.sort(Comparator.comparingInt(Passenger::returnPassengerDestination));
    }

    /**
     * Sorts ArrayList of passenger from greatest to least
     */
    public void sortGreatestLeast() {
        this.passengers.sort(Comparator.comparingInt(Passenger::returnPassengerDestination));

        ArrayList<Passenger> reversedList = new ArrayList();

        for (int i = this.passengers.size() - 1; i >= 0; i--) {
            reversedList.add(this.passengers.get(i));
        }


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