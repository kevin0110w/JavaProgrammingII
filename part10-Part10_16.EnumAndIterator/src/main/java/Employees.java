
import java.util.ArrayList;
import java.util.Iterator;
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
public class Employees {

    private List<Person> persons;

    public Employees() {
        persons = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.persons.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        this.persons.addAll(peopleToAdd);
    }

    public void print() {
        Iterator<Person> it = persons.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void print(Education education) {
        Iterator<Person> it = persons.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            if (p.getEducation().equals(education)) {
                System.out.println(p);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> it = persons.iterator();
        while (it.hasNext()) {
            if (it.next().getEducation().equals(education)) {
                it.remove();
            }
        }
    }

}
