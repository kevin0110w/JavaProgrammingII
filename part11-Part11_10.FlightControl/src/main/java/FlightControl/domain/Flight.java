package FlightControl.domain;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class Flight {
    private String id;
    private Airplane airplane;
    private Airport departureAirport;
    private Airport targetAirport;

    public Flight(Airplane airplane, Airport departureAirport, Airport targetAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.targetAirport = targetAirport;
        this.setId(this.toString());
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getTargetAirport() {
        return targetAirport;
    }

    public void setTargetAirport(Airport targetAirport) {
        this.targetAirport = targetAirport;
    }

    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.airplane);
        hash = 71 * hash + Objects.hashCode(this.departureAirport);
        hash = 71 * hash + Objects.hashCode(this.targetAirport);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flight other = (Flight) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return this.airplane + " (" + this.departureAirport + "-" + this.targetAirport + ")";
    }
}
