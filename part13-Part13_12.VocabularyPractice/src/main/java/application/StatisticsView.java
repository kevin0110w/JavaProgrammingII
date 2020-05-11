/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author woohoo
 */
public class StatisticsView {

    private Statistics stats;

    public StatisticsView(Statistics stats) {
        this.stats = stats;
    }

    public Parent getLayout() {
        GridPane layout = new GridPane();

        Label statistics = new Label("--STATISTICS--");
        Label totalNumberOfGuessesLabel = new Label("Total number of guesses: " + this.stats.getTotalNumberOfGuesses());

        Label mostGuessedWordLabel = new Label("Most guessed word: " + this.stats.getMostGuessedWord().getWord() + " (" + (this.stats.getMostGuessedWord().getSuccessfulGuesses() + this.stats.getMostGuessedWord().getUnsuccessfulGuesses()) + ") guesses.");
        Label bestGuessedWordLabel = new Label("Most successfully guessed word: " + this.stats.getMostCorrectTranslations().getWord() + " (" + this.stats.getMostCorrectTranslations().getSuccessfulGuesses() + ") correct guesses.");
        Label worstGuessedWordLabel = new Label("Least successfully guessed word: " + this.stats.getMostIncorrectTranslations().getWord() + " (" + this.stats.getMostIncorrectTranslations().getSuccessfulGuesses() + ") correct guesses.");

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        layout.add(statistics, 0, 0);
        layout.add(totalNumberOfGuessesLabel, 0, 1);
        layout.add(mostGuessedWordLabel, 0, 2);
        layout.add(bestGuessedWordLabel, 0, 3);
        layout.add(worstGuessedWordLabel, 0, 4);
        return layout;
    }
}
