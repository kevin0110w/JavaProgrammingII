
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
public class Herd implements Movable {

    private List<Movable> herd;

    public Herd() {
        this.herd = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Movable m : this.herd) {
            s.append(m.toString());
            s.append("\n");
        }
        
        return s.toString();
    }

    @Override
    public void move(int dx, int dy) {
        this.herd.stream()
                .forEach(movable -> movable.move(dx, dy));
    }
}
