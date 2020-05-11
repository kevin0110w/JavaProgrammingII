
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
public class TodoList {

    private List<String> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        this.tasks.add(task);
    }

    public void print() {
        int counter = 1;
        for (String task : this.tasks) {
            System.out.println(counter + ": " + task);
            counter++;
        }
    }

    public void remove(int number) {
        this.tasks.remove(number - 1);
    }
}
