package application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Statistic {
    public String word;
    public int successfulGuesses;
    public int unsuccessfulGuesses;
    public double averageSuccessfulGuessRate;

    public Statistic(String word) {
        this.word = word;
        this.successfulGuesses = 0;
        this.unsuccessfulGuesses = 0;
        this.averageSuccessfulGuessRate = 0.0;
    }

    public String getWord() {
        return word;
    }

    public int getSuccessfulGuesses() {
        return successfulGuesses;
    }

    public int getUnsuccessfulGuesses() {
        return unsuccessfulGuesses;
    }

    public double getAverageSuccessfulGuessRate() {
        return averageSuccessfulGuessRate;
    }

    public void incrementSuccessfulGuess() {
        this.successfulGuesses++;
    }
   
    public void incrementUnsuccessfulGuess() {
        this.unsuccessfulGuesses++;
    }
    
    public double getAverage() {
        int total = this.successfulGuesses + this.unsuccessfulGuesses;
        return (1.0 * this.successfulGuesses) / total;
    }
}
