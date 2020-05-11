/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class LiteracyLevel implements Comparable<LiteracyLevel> {
    private String country;
    private int year;
    private String gender;
    private double percent;

    public LiteracyLevel(String country, int year, String gender, double percent) {
        this.country = country;
        this.year = year;
        this.gender = gender;
        this.percent = percent;
        setGender();
    }

    public void setGender() {
        if (this.gender.contains("female")) {
            this.gender = "female";
        } else {
            this.gender = "male";
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
    
    
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.percent;
    }

    @Override
    public int compareTo(LiteracyLevel o) {
        if (this.getPercent() > o.getPercent()) {
            return 1;
        } else if (this.getPercent() < o.getPercent()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    
}
