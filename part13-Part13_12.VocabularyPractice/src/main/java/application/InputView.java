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
import javafx.scene.layout.StackPane;

/**
 *
 * @author woohoo
 */
public class InputView {

    private Dictionary dictionary;

    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordInstruction = new Label("Word: ");
        TextField wordField = new TextField();

        Label translationInstruction = new Label("Translation: ");
        TextField translationField = new TextField();
        
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        Button button = new Button("Submit");
        
        StackPane successfulLayout = createView("Word added successfully.");
        StackPane unsuccessfulLayout = createView("Word already added.");
        
        layout.add(wordInstruction, 0, 0);
        layout.add(wordField, 1, 0);
        layout.add(translationInstruction, 0, 1);
        layout.add(translationField, 1, 1);
        layout.add(button, 0, 2);
        

        button.setOnAction((event) -> {
            this.dictionary.addTranslations(wordField.getText(), translationField.getText());
            wordField.clear();
            translationField.clear();
        });
        return layout;
    }
    
    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
