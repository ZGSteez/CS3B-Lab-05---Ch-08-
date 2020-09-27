/*
 * Car main
 * Assignment 5 - Programming Project 8.04
 * Chapter 08
 *
 * @author Zhuo Guan, Carlo Navata
 * Implementing the Station class
 *  A Station class that has a member variable of an ArrayList of Stations. The station is constructed with either the default constructor or
 * a construction with parameters of Passenger and Car.
 *
 */

package CarSharingSimulation;

import java.util.*;
import java.util.Random;

public class Station {

    private ArrayList<Station> thirtyStations = new ArrayList<>();
    private final int AMOUNT_OF_STATIONS = 30;
    private final double PAY_PER_MILE = 7.00;
    private double totalRevenue = 0;
    private double milesDriven = 0;
    private final int MINIMUM_PASSENGERS_AT_STATION = 25;
    private final int MAXIMUM_PASSENGERS_AT_STATION_RANGE = 25;
    private final int MINIMUM_CARS_AT_STATION = 5;
    private final int MAXIMUM_CARS_AT_STATION_RANGE = 5;
    private Passenger allPassengersAtStation;
    private Car allCarsAtStation;

    /**
     *
     * @param passengerObject - passenger object containing ArrayList of Passengers
     * @param carObject - Car object containing Arraylist of Cars
     */
    public Station(Passenger passengerObject, Car carObject) {
        this.allPassengersAtStation = passengerObject;
        this.allCarsAtStation = carObject;
    }

    /**
     * Default constructor
     */
    public Station() {
    }

    public void generateStations() {
        Random random = new Random();

        int randomAmountOfPassengers = random.nextInt(MAXIMUM_PASSENGERS_AT_STATION_RANGE) + MINIMUM_PASSENGERS_AT_STATION;
        Passenger allPassengers = new Passenger();

        for (int i = 0; i < randomAmountOfPassengers; i++) {
            Passenger aPassenger = new Passenger();
            aPassenger.getPassengerDestination();
            allPassengers.add(aPassenger);
        }

        int randomAmountOfCars = random.nextInt(MAXIMUM_CARS_AT_STATION_RANGE) + MINIMUM_CARS_AT_STATION;
        Car allCars = new Car();

        for (int i = 0; i < randomAmountOfCars; i++) {
            Car aCar = new Car();
            aCar.getCarDestination();
            allCars.add(aCar);
        }
        this.thirtyStations.add(new Station(allPassengers, allCars));
    }

    /**
     * Returns arraylist of station
     * @return - returns an arrayList of type Station
     */
    public ArrayList<Station> returnStationArrayList() {
        return this.thirtyStations;
    }

    /**
     * Adds first 3 passengers at starting station to Car Object and removes any errors it finds from the
     * automatic generation of Station Objects with parameters passenger and car
     */
    public void pickUpFirstPassengers() {          // mutator
        for (int currentStation = 0; currentStation < AMOUNT_OF_STATIONS; currentStation++) {            // i = current station
            Station station = this.thirtyStations.get(currentStation);
            Passenger passenger = station.returnPassenger();
            Car car = station.returnCar();
            ArrayList<Car> allCarsAtStation = car.returnAllCars();
            ArrayList<Passenger> allPassengersAtStation = passenger.returnAllPassengers();

            for (int carIterator = 0; carIterator < allCarsAtStation.size(); carIterator++) {
                Car currentCar = allCarsAtStation.get(carIterator);
                int carDestination = currentCar.returnCarDestination();

                for (int passengerIterator = 0; passengerIterator < allPassengersAtStation.size(); passengerIterator++) {
                    Passenger currentPassenger = allPassengersAtStation.get(passengerIterator);
                    int passengerDestination = currentPassenger.returnPassengerDestination();

                    if (carDestination > currentStation) { // currentStation < destination
                        if (carDestination >= passengerDestination && passengerDestination > currentStation) {
                            if (currentCar.passengersInCar() == 3) {
                                break;
                            }

                            currentCar.addPassenger(currentPassenger);      // adds passenger to car
                            allPassengersAtStation.remove(currentPassenger);    // removes passenger object from passenger arraylist
                            Passenger newPassenger = new Passenger();
                            allCarsAtStation.set(carIterator, currentCar);
                            Car newCar = new Car();
                            newCar.updateAllCars(allCarsAtStation);
                            newPassenger.updateAllPassengers(allPassengersAtStation);   // updates passenger arrayLIst
                            this.thirtyStations.set(currentStation, new Station(newPassenger, newCar));   // updates Station ArrayList
                        }

                    } else if (carDestination < currentStation) {  // currentStation > destination
                        if (carDestination <= passengerDestination && passengerDestination < currentStation) {
                            if (currentCar.passengersInCar() == 3) {
                                break;
                            }
                            currentCar.addPassenger(currentPassenger);      // adds passenger to car
                            allPassengersAtStation.remove(currentPassenger);    // removes passenger object from passenger arraylist
                            Passenger newPassenger = new Passenger();
                            allCarsAtStation.set(carIterator, currentCar);
                            Car newCar = new Car();
                            newCar.updateAllCars(allCarsAtStation);
                            newPassenger.updateAllPassengers(allPassengersAtStation);   // updates passenger arrayLIst
                            this.thirtyStations.set(currentStation, new Station(newPassenger, newCar));   // updates Station ArrayList
                        }

                    } else if (carDestination == currentStation) {      // deletes car object if car destination = currentStation
                        ArrayList<Car> carListCopy = allCarsAtStation;
                        carListCopy.remove(currentCar);
                        Car newCar = new Car();
                        newCar.updateAllCars(carListCopy);
                        this.thirtyStations.set(currentStation, new Station(passenger, newCar));
                    }
                }
            }
        }
    }

    /**
     * Returns passenger object contained in station object
     * @return - returns object of type passenger
     */
    public Passenger returnPassenger() {
        return this.allPassengersAtStation;
    }

    /**
     * Returns car object contained in station object
     * @return - returns object of type car
     */
    public Car returnCar() {
        return this.allCarsAtStation;
    }

    /**
     * Returns total cars at all stations
     * @return - returns an int of the sum of all cars at station
     */
    public int returnTotalCarsAtAllStations() {
        int totalCars = 0;
        for (Station iterator : this.thirtyStations) {
            //Passenger passenger = iterator.returnPassenger();
            Car car = iterator.returnCar();
            totalCars += car.totalCarsAtStation();
        }
        return totalCars;
    }

    /**
     * Calculates the revenue for each car and for all car objects at all stations and adds new passengers if possible
     * @return - double of the average revenue per mile for all cars at all stations
     */
    public double calculateRevenuePerMile() {
        for (int currentStation = 0; currentStation < AMOUNT_OF_STATIONS; currentStation++) {
            Station station = this.thirtyStations.get(currentStation);

            Car carObject = station.returnCar();
            Passenger passengerObject = station.returnPassenger();

            ArrayList<Car> carList = carObject.returnAllCars();
            ArrayList<Passenger> passengerList = passengerObject.returnAllPassengers();

            for (int currentCar = 0; currentCar < carList.size(); currentCar++) {
                Car car = carList.get(currentCar);
                car.sortFromLeastToGreatest();

                while (car.passengersInCar() != 0) {

                    ArrayList<Passenger> passenger = car.returnPassengerList();

                    for (int j = 0; j < car.returnPassengerList().size(); j++) {
                        Passenger aPassenger = passenger.get(j);
                        this.totalRevenue += (Math.abs(aPassenger.returnPassengerDestination() - currentStation) * PAY_PER_MILE);

                        // working on picking up additional passengers when stopping at passenger destination
                        car.removePassenger(aPassenger);


                        if (car.returnCarDestination() > currentStation) {

                        } else if (car.returnCarDestination() < currentStation) {

                        }


                        carList.set(currentCar, car);

                        Car iterator = new Car();
                        iterator.updateAllCars(carList);
                        this.thirtyStations.set(currentStation, new Station(passengerObject, carObject));

                    }


                }

                this.milesDriven += (Math.abs(car.returnCarDestination() - currentStation));

            }


        }
        return this.totalRevenue / this.milesDriven;
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