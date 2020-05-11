/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.view;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import java.util.Map;

/**
 *
 * @author woohoo
 */
public class View {

    public View() {
    }

    public void printAirportAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println("");
    }
    
    public void printAirportAssetControlActions() {
        System.out.println("Choose an action:");
        System.out.println("[1] Add an airplane");
        System.out.println("[2] Add a flight");
        System.out.println("[x] Exit Airport Asset Control");
        System.out.print("> ");
    }

    public void printGiveAirplaneID() {
        System.out.print("Give the airplane id: ");
    }

    public void printGiveAirplaneCapacity() {
        System.out.print("Give the airplane capacity: ");
    }

    public void printGiveDepartureAirport() {
        System.out.print("Give the departure airport id: ");
    }

    public void printGiveTargetAirport() {
        System.out.print("Give the target airport id: ");
    }

    public void printFlightControl() {
        System.out.println("Flight Control");
        System.out.println("--------------------");
        System.out.println("");
    }
    
    public void printFlightControlActions() {
        System.out.println("Choose an action:");
        System.out.println("[1] Print airplanes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print airplane details");
        System.out.println("[x] Quit");
        System.out.print("> ");
    }

    public void printAirplanes(Map<String, Airplane> airplanes) {
        airplanes.values().stream()
                .forEach((airplane) -> {
                    System.out.println(airplane);
                });
    }

    public void printFlights(Map<String, Flight> flights) {
        flights.values().stream()
                .forEach((flight) -> {
                    System.out.println(flight);
                });
    }

    public void printSpecificAirplane(Airplane plane) {
        System.out.println(plane);
        System.out.println("");
    }
}
