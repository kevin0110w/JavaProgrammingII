/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author woohoo
 */
public class Model {

    private Map<String, Airplane> airplanes;
    private Map<String, Flight> flights;

    public Model() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
    }

    public void addAirplane(Airplane aPlane) {
        this.airplanes.putIfAbsent(aPlane.getId(), aPlane);
    }
    
    public void addFlight(Flight aFlight) {
        this.flights.putIfAbsent(aFlight.getId(), aFlight);
    }

    public Map<String, Airplane> getAirplanes() {
        return airplanes;
    }

    public Map<String, Flight> getFlights() {
        return flights;
    }
    
    public Airplane getSpecificAirplane(String airplaneID) {
        return this.airplanes.getOrDefault(airplaneID, null);
    }
}
