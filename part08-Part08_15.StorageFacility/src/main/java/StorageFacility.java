
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class StorageFacility {

    public HashMap<String, ArrayList> units;

    public StorageFacility() {
        this.units = new HashMap<>();
    }

    public void add(String unit, String item) {
        ArrayList<String> items = contents(unit);
        items.add(item);
        this.units.put(unit, items);
    }

    public ArrayList<String> contents(String storageUnit) {
        return this.units.getOrDefault(storageUnit, new ArrayList());
    }

    public void remove(String storageUnit, String item) {
        ArrayList<String> items = contents(storageUnit);
        items.remove(item);

        if (items.size() > 0) {
            this.units.put(storageUnit, items);
        } else {
            this.units.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        return this.units.keySet().stream()
                .filter(unit -> this.units.get(unit).size() > 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
