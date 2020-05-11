
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
public class BoxWithMaxWeight extends Box {

    private int maxWeight;
    private List<Item> items;

    public BoxWithMaxWeight(int weight) {
        super();
        this.maxWeight = weight;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        int weight = this.items.stream()
                .mapToInt(anItem -> anItem.getWeight())
                .sum();

        if (weight + item.getWeight() <= maxWeight) {
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }

}
