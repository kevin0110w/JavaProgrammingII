
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Warehouse {
    private Map<String, Integer> productCosts;
    private Map<String, Integer> productStocks;

    public Warehouse() {
        this.productCosts = new HashMap<>();
        this.productStocks = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.productCosts.putIfAbsent(product, price);
        this.productStocks.putIfAbsent(product, stock);
    }

    public int price(String product) {
        return this.productCosts.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return this.productStocks.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        if (!this.productStocks.containsKey(product)) {
            return false;
        }
        
        int stock = stock(product);
        if (stock == 0) {
            return false;
        }
        
        stock = stock -1;
        this.productStocks.put(product, stock);
        return true;
    }
    
    public Set<String> products() {
        return this.productStocks.keySet();
    }
}
