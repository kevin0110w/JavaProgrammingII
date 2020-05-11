
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Pipe<T> {
    private List<T> items;

    public Pipe() {
        this.items = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        this.items.add(value);
    }
    
    public T takeFromPipe() {
        if (this.items.isEmpty()) {
            return null;
        }
        T thing = this.items.get(0);
        this.items.remove(0);
        return thing;
    }
    
    public boolean isInPipe() {
        return !this.items.isEmpty();
    }
}
