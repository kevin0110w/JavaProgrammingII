
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
public class Hideout<T> {

    private T object;

    public Hideout() {

    }

    public void putIntoHideout(T toHide) {
        if (this.object == null) {
            this.object = toHide;
        }
    }

    public T takeFromHideout() {
        T thing = this.object;
        if (thing != null) {
            this.object = null;
        }
        return thing;
    }

    
    public boolean isInHideout() {
        return this.object != null;
    }
}
