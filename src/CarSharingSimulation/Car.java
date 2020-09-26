package CarSharingSimulation;
import java.util.*;


public class Car {
    private final  int AMOUNT_OF_STATIONS = 30;
    private ArrayList <Car> allCars = new ArrayList<>();
    private int carDestination;
    private int currentStation;
    private ArrayList<Passenger> passengers = new ArrayList();

    public void getCarDestination(){
        Random random = new Random();
        int station = random.nextInt(AMOUNT_OF_STATIONS);
        this.carDestination = station;
    }

    public int returnCarDestination(){
        return this.carDestination;
    }

    public ArrayList<Car> returnAllCars(){
        return this.allCars;
    }

    public void add(Car aCar){
        allCars.add(aCar);
    }

    public int totalCarsAtStation(){
        return this.allCars.size();
    }

    public void addPassenger(Passenger aPassenger){
        this.passengers.add(aPassenger);
    }

    public void removePassenger(Passenger aPassenger){
        this.passengers.remove(aPassenger);
    }

    public int passengersInCar(){
        return this.passengers.size();
    }

    public void updateAllCars(ArrayList<Car> updatedAllCars){
        this.allCars = updatedAllCars;

    }

    public ArrayList<Passenger> returnPassengerList(){
        return this.passengers;
    }

    public void sortFromLeastToGreatest(){
       this.passengers.sort(Comparator.comparingInt(Passenger::returnPassengerDestination));
    }

    public void sortGreatestLeast(){
        this.passengers.sort(Comparator.comparingInt(Passenger::returnPassengerDestination));

        ArrayList<Passenger> reversedList = new ArrayList();

        for (int i = this.passengers.size() - 1; i >= 0;i--){
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