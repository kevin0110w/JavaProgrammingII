/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author woohoo
 */
public class PracticeView {

    private Dictionary dictionary;
    private Statistics stats;
    private String word;

    public PracticeView(Dictionary dictionary, Statistics stats) {
        this.dictionary = dictionary;
        this.stats = stats;

    }

    public Parent getView() {
        this.word = this.dictionary.getRandomWord();
        GridPane layout = new GridPane();

        Label wordInstruction = new Label("Translate the following word: " + this.word);
        TextField entryField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button button = new Button("Translate!");
        Label feedback = new Label("");

        layout.add(wordInstruction, 0, 0);
        layout.add(entryField, 0, 1);
        layout.add(button, 0, 2);
        layout.add(feedback, 0, 3);

        button.setOnAction((event) -> {
            String translation = entryField.getText();
            this.stats.addStat(this.word);
            if (this.dictionary.getTranslation(this.word).equals(translation)) {
                feedback.setText("Correct!");
                this.stats.incrementsuccessfulGuess(this.word);
            } else {
                feedback.setText("Incorrect! The correct translation for the word '" + this.word + "' is '" + this.dictionary.getTranslation(word) + "'.");
                this.stats.incrementunsuccessfulGuess(this.word);
            }
            this.word = this.dictionary.getRandomWord();
            wordInstruction.setText("Translate the following word: " + this.word);
            entryField.clear();
        });
        return layout;
    }

}
