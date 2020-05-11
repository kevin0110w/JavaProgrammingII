/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author woohoo
 */
public class View {

    private final int numberOfButtons = 9;
    private final int numberOfColumns = 3;
    private final int numberOfRows = 3;
    private Model model;
    private WinnerChecker winnerChecker;
    private Label scoreLabel;
    private int counter;

    public View(Model model) {
        this.model = model;
        this.winnerChecker = new WinnerChecker();
        this.counter = 1;
    }

    public Parent getLayout() {
        BorderPane layout = new BorderPane();

        this.scoreLabel = new Label(" ");
        GridPane board = new GridPane();

        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                board.add(button, column, row);
                this.winnerChecker.addButton(button);
            }
        }
        this.scoreLabel.setText(this.model.getActivePlayer().toString());
        this.setActions(board);
        layout.setTop(scoreLabel);
        layout.setCenter(board);
        return layout;
    }

    private void disableButtons(GridPane board) {
        for (Node n : board.getChildren()) {
            n.setDisable(true);
        }
    }

    private void setActions(GridPane board) {
        for (Node button : board.getChildren()) {
            ((Button) button).setOnAction((event) -> {
                ((Button) button).setText(model.getActivePlayer().getName());
                if (this.winnerChecker.determineWinner() || this.counter == 9) {
                    this.model.setWinner(model.getActivePlayer());
                    this.scoreLabel.setText("The end!");
                    disableButtons(board);
                    return;
                };
                this.model.incrementRound();
                this.scoreLabel.setText(model.getActivePlayer().toString());
                ((Button) button).setDisable(true);

                this.counter++;

            });
        }
    }
}
