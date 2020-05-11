
import java.util.HashMap;
import java.util.HashSet;
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
public class VehicleRegistry {

    private HashMap<LicensePlate, String> owners;

    public VehicleRegistry() {
        this.owners = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (this.owners.containsKey(licensePlate)) {
            return false;
        }

        this.owners.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate) {
        return this.owners.getOrDefault(licensePlate, null);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (this.owners.containsKey(licensePlate)) {
            this.owners.remove(licensePlate);
            return true;
        }
        return false;
    }

    public void printLicensePlates() {
        this.owners.keySet().forEach((l) -> {
            System.out.println(l);
        });
    }

    public void printOwners() {
        Set<String> uniqueOwners = new HashSet<>();

        for (LicensePlate l : this.owners.keySet()) {
            uniqueOwners.add(this.owners.get(l));
        }

        uniqueOwners.stream().
                forEach(owner -> System.out.println(owner));
    }
}
