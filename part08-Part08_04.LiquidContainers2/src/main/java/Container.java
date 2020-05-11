/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Container {

    private int contents;

    public Container() {
        this.contents = 0;
    }

    public int contains() {
        return this.contents;
    }

    public void add(int amount) {
        if (amount < 0) {
            return;
        }

        this.contents += amount;

        if (this.contents > 100) {
            this.contents = 100;
        }
    }

    public void remove(int amount) {
        if (amount < 0) {
            return;
        }

        this.contents -= amount;

        if (this.contents < 0) {
            this.contents = 0;
        }
    }
    
    public String toString() {
       return this.contents + "/100";
    }
}
