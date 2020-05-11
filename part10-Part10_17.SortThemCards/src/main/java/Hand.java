
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
public class Hand implements Comparable<Hand> {

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        cards.stream()
                .forEach(System.out::println);
    }

    public void sort() {
        this.cards = cards.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Hand o) {
        int sumOfHandOne = this.cards.stream()
                .mapToInt(card -> card.getValue())
                .sum();

        int sumOfHandTwo = o.cards.stream()
                .mapToInt(card -> card.getValue())
                .sum();

        return sumOfHandOne - sumOfHandTwo;

    }

    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());

        this.cards.forEach((card) -> {
            System.out.println(card);
        });
    }
}
