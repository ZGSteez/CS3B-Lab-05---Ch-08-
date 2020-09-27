package CarSharingSimulation;

import java.util.*;

public class Simulation {
    public static void main(String[] args) {
        final int AMOUNT_OF_STATIONS = 30;
        final int NUMBER_OF_SIMULATIONS = 1000;
        int simulationsRun = 0;
        double revenueSum = 0;

        while (simulationsRun < NUMBER_OF_SIMULATIONS) {

            Station stationObject = new Station();
            for (int i = 0; i < AMOUNT_OF_STATIONS; i++) {
                stationObject.generateStations();
            }

//            ArrayList<Station> stationList = stationObject.returnStationArrayList();
//
//            double passengerSum = 0;
//            double carSum = 0;
//
//            for (Station c : stationList) {
//
//
//                Passenger a = c.returnPassenger();
//                Car b = c.returnCar();
//                passengerSum += a.totalPassengersAtStation();
//                carSum += b.totalCarsAtStation();
//
//            }
//            System.out.println("The average amount of passengers at each station is : " + String.format("%,.2f", (passengerSum / AMOUNT_OF_STATIONS)));
//            System.out.println("The average amount of cars at each station is: " + String.format("%,.2f", (carSum / AMOUNT_OF_STATIONS)));
//            System.out.println("The total amount of cars at all station is : " + carSum);
//            System.out.println("The total amount of passengers at all stations is : " + passengerSum);

            stationObject.pickUpFirstPassengers();

//            stationList = stationObject.returnStationArrayList();

//            passengerSum = 0;
//            carSum = 0;
//
//            for (Station c : stationList) {
//
//
//                Passenger a = c.returnPassenger();
//                Car b = c.returnCar();
//                passengerSum += a.totalPassengersAtStation();
//                carSum += b.totalCarsAtStation();
//
//
//            }
//            System.out.println("The average amount of passengers at each station is : " + String.format("%,.2f", (passengerSum / AMOUNT_OF_STATIONS)));
//            System.out.println("The average amount of cars at each station is: " + String.format("%,.2f", (carSum / AMOUNT_OF_STATIONS)));
//            System.out.println("The total amount of cars at all station is : " + carSum);
//            System.out.println("The total amount of passengers at all stations is : $" + passengerSum);


//        for (int i = 0; i < AMOUNT_OF_STATIONS;i++) {
//
//            Station newStation = stationList.get(i);
//
//            Passenger a = newStation.returnPassenger();
//            Car b = newStation.returnCar();
//            ArrayList<Car> carList = b.returnAllCars();
//            System.out.println("The current Station is : " + i);
//            for (Car d : carList){
//               System.out.println("Car destination, passenger Destination : " + d.returnCarDestination());
//                for (Passenger e : d.returnPassengerList()){
//                    System.out.print(e.returnPassengerDestination() + "     ");
//                }
//            }
//
//            passengerSum += a.totalPassengersAtStation();
//            carSum += b.totalCarsAtStation();
//
//
//
//
//        }

            revenueSum += stationObject.calculateRevenuePerMile();
            simulationsRun++;


        }

        System.out.println("The average revenue per mile for " + NUMBER_OF_SIMULATIONS +
                " simulations is : $" + String.format("%,.2f", revenueSum / simulationsRun));

    }

}
