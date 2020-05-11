/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author woohoo
 */
public class AverageSensor implements Sensor {
    private List<Integer> readings;
    private List<Sensor> sensors;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        for (Sensor s : this.sensors) {
            if (!s.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        this.sensors.stream()
                .forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        this.sensors.stream()
                .forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if (this.sensors.size() == 0 || !this.isOn()) {
            throw new IllegalStateException();
        }

        int reading = (int) this.sensors.stream()
                .mapToInt(sensor -> sensor.read())
                .average()
                .getAsDouble();
        
        this.readings.add(reading);
        return reading;
    }

    public List<Integer> readings() {
        return this.readings;
    }
}
