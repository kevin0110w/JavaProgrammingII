/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author woohoo
 */
public class Statistics {

    public Map<String, Statistic> stats;

    public Statistics() {
        this.stats = new HashMap<>();
    }

    public void addStat(String word) {
        if (this.stats.containsKey(word)) {
            return;
        }
        Statistic s = new Statistic(word);
        this.stats.put(word, s);
    }

    public Statistic getStat(String word) {
        return this.stats.getOrDefault(word, null);
    }

    public Statistic getMostGuessedWord() {
        int highest = 0;
        Statistic toReturn = null;
        for (Statistic s : this.stats.values()) {
            if (s.getSuccessfulGuesses() + s.getUnsuccessfulGuesses() > highest) {
                highest = s.getSuccessfulGuesses() + s.getUnsuccessfulGuesses();
                toReturn = s;
            }
        }
        return toReturn;
    }

    public Statistic getMostCorrectTranslations() {
        int highest = 0;
        Statistic toReturn = null;
        for (Statistic s : this.stats.values()) {
            if (s.getSuccessfulGuesses() >= highest) {
                highest = s.getSuccessfulGuesses();
                toReturn = s;
            }
        }
        return toReturn;
    }

    public Statistic getMostIncorrectTranslations() {
        int highest = 0;
        Statistic toReturn = null;
        for (Statistic s : this.stats.values()) {
            if (s.getUnsuccessfulGuesses() >= highest) {
                highest = s.getUnsuccessfulGuesses();
                toReturn = s;
            }
        }
        return toReturn;
    }

    public ArrayList<Statistic> returnAllStats() {
        return this.stats.values().stream()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void incrementsuccessfulGuess(String word) {
        Statistic s = this.stats.get(word);
        s.incrementSuccessfulGuess();
        this.stats.put(word, s);
    }

    public void incrementunsuccessfulGuess(String word) {
        Statistic s = this.stats.get(word);
        s.incrementUnsuccessfulGuess();
        this.stats.put(word, s);
    }

    public int getTotalNumberOfGuesses() {
        int guesses = 0;
        for (String word : this.stats.keySet()) {
            guesses += this.stats.get(word).getSuccessfulGuesses() + this.stats.get(word).getUnsuccessfulGuesses();
        }
        return guesses;
    }
}
