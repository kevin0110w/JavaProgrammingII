/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author woohoo
 */
public class Parties {

    private String partyName;
    private Map<Integer, Double> yearlyRatings;

    public Parties(String partyName) {
        this.partyName = partyName;
        this.yearlyRatings = new HashMap<>();
    }

    public String getPartyName() {
        return partyName;
    }

    public Map<Integer, Double> getYearlyRatings() {
        return yearlyRatings;
    }

    public void addYearlyRatings(int year, double rating) {
        this.yearlyRatings.putIfAbsent(year, rating);
    }
}
