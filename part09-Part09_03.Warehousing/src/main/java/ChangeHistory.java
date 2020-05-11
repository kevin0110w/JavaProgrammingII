
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class ChangeHistory {

    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        this.history.add(status);
    }

    public void clear() {
        this.history.clear();
    }

    @Override
    public String toString() {
        return this.history.toString();
    }

    public double maxValue() {
        double maximum = 0.0;
        for (Double number : this.history) {
            if (number > maximum) {
                maximum = number;
            }
        }
        return maximum;
    }

    public double minValue() {
        double minimum = 0.0;
        if (this.history.size() == 0) {
            return minimum;
        }
        minimum = this.history.get(0);
        for (Double number : this.history) {
            if (number < minimum) {
                minimum = number;
            }
        }
        return minimum;
    }

    public double average() {
        double average = 0.0;
        if (this.history.size() == 0) {
            return average;
        }
        for (Double number : this.history) {
            average += number;
        }
        return average / this.history.size();
    }
}
