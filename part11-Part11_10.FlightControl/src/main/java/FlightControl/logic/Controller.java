/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Airport;
import FlightControl.domain.Flight;
import FlightControl.domain.Model;
import FlightControl.view.View;
import java.util.Scanner;

/**
 *
 * @author woohoo
 */
public class Controller {

    private Model model;
    private View view;
    private Scanner scanner;

    public Controller(Model model, View view, Scanner scanner) {
        this.model = model;
        this.view = view;
        this.scanner = scanner;
    }

    public void start() {
        handleAirportAssetControl();
        handleFlightControl();
    }

    private void handleAirportAssetControl() {
        this.view.printAirportAssetControl();
        while (true) {
            this.view.printAirportAssetControlActions();
            String action = this.scanner.nextLine();
            if (action.toUpperCase().equals("X")) {
                return;
            }

            if (action.equals("1")) {
                manageAirplaneAddition();
            } else if (action.equals("2")) {
                manageFlightAddition();
            }
        }
    }

    private void manageAirplaneAddition() {
        this.view.printGiveAirplaneID();
        String airplaneID = this.scanner.nextLine();
        this.view.printGiveAirplaneCapacity();
        int airplaneCapacity = Integer.valueOf(this.scanner.nextLine());

        this.model.addAirplane(new Airplane(airplaneID, airplaneCapacity));
    }

    private void manageFlightAddition() {
        this.view.printGiveAirplaneID();
        String airplaneID = this.scanner.nextLine();
        Airplane thePlane = this.model.getSpecificAirplane(airplaneID);

        this.view.printGiveDepartureAirport();
        String departureAirport = this.scanner.nextLine();

        this.view.printGiveTargetAirport();
        String targetAirport = this.scanner.nextLine();

        if (thePlane == null) {
            return;
        }

        this.model.addFlight(new Flight(thePlane, new Airport(departureAirport), new Airport(targetAirport)));
    }

    private void handleFlightControl() {
        this.view.printFlightControl();
        while (true) {
            this.view.printFlightControlActions();
            String action = this.scanner.nextLine();
            if (action.toUpperCase().equals("X")) {
                return;
            }

            if (action.equals("1")) {
                managePrintAirplanes();
            } else if (action.equals("2")) {
                managePrintFlights();
            } else if (action.equals("3")) {
                managePrintSpecificAirplane();
            }
        }
    }

    private void managePrintAirplanes() {
        this.view.printAirplanes(this.model.getAirplanes());
    }

    private void managePrintFlights() {
        this.view.printFlights(this.model.getFlights());
    }

    private void managePrintSpecificAirplane() {
        this.view.printGiveAirplaneID();
        String airplaneId = this.scanner.nextLine();
        this.view.printSpecificAirplane(this.model.getSpecificAirplane(airplaneId));
    }

}
