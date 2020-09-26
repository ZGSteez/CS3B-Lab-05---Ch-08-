package CarSharingSimulation;
import java.util.*;
import java.util.Random;

public class Passenger {
    private final int AMOUNT_OF_STATIONS = 30;
    private ArrayList<Passenger> allPassengers = new ArrayList<>();
    private int passengerDestination;


    public void getPassengerDestination(){
        Random random = new Random();
        int station = random.nextInt(AMOUNT_OF_STATIONS);
        this.passengerDestination = station;
    }

    public int returnPassengerDestination(){
        return this.passengerDestination;
    }

    public ArrayList<Passenger> returnAllPassengers(){
        return this.allPassengers;
    }

    public void add(Passenger aPassenger){
        allPassengers.add(aPassenger);
    }

    public int totalPassengersAtStation(){
        return this.allPassengers.size();

    }
    public void updateAllPassengers(ArrayList<Passenger> updateAllPassengers){
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