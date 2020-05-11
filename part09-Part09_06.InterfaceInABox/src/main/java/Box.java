
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class Box implements Packable {

    private List<Packable> items;
    private double capacity;

    public Box(double capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public double weight() {
        double weight = this.items.stream()
                .mapToDouble(anItem -> anItem.weight())
                .sum();
        return weight;
    }

    public void add(Packable item) {
        if (weight() + item.weight() <= this.capacity) {
            this.items.add(item);
        }
    }

    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
}
