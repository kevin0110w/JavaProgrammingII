
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class ShoppingCart {

    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        Item i = new Item(product, 1, price);

        if (this.items.containsKey(product)) {
            i = this.items.get(product);
            i.increaseQuantity();
        }

        this.items.put(product, i);
    }

    public int price() {
        return this.items.values().stream()
                .mapToInt(item -> item.price())
                .sum();
    }

    public void print() {
        for (Item i : this.items.values()) {
            System.out.println(i);
        }
    }

}
