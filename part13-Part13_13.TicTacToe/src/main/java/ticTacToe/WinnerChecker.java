/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;

/**
 *
 * @author woohoo
 */
public class WinnerChecker {

    private final String initialString = " ";
    private List<Button> buttons;

    public WinnerChecker() {
        this.buttons = new ArrayList<>();
    }

    public void addButton(Button btn) {
        this.buttons.add(btn);
    }

    public boolean determineWinner() {
        return checkTopRow() || checkMiddleRow() || checkBottomRow() || checkLeftColumn() || checkMiddleColumn() || checkTopLToBotRDiag() || checkBotLToTopRDiag();
    }

    private boolean checkTopRow() {
        if (buttons.get(0).getText().equals(this.initialString) || buttons.get(1).getText().equals(this.initialString) || buttons.get(2).getText().equals(this.initialString)) {
            return false;
        }
        return buttons.get(0).getText().equals(buttons.get(1).getText()) && buttons.get(1).getText().equals(buttons.get(2).getText());

    }

    private boolean checkMiddleRow() {
        if (buttons.get(3).getText().equals(this.initialString) || buttons.get(4).getText().equals(this.initialString) || buttons.get(5).getText().equals(this.initialString)) {
            return false;
        }

        return buttons.get(3).getText().equals(buttons.get(4).getText()) && buttons.get(4).getText().equals(buttons.get(5).getText());
    }

    private boolean checkBottomRow() {
        if (buttons.get(6).getText().equals(this.initialString) || buttons.get(7).getText().equals(this.initialString) || buttons.get(8).getText().equals(this.initialString)) {
            return false;
        }

        return buttons.get(6).getText().equals(buttons.get(7).getText()) && buttons.get(7).getText().equals(buttons.get(8).getText());
    }

    private boolean checkLeftColumn() {
        if (buttons.get(0).getText().equals(this.initialString) || buttons.get(3).getText().equals(this.initialString) || buttons.get(6).getText().equals(this.initialString)) {
            return false;
        }

        return buttons.get(0).getText().equals(buttons.get(3).getText()) && buttons.get(3).getText().equals(buttons.get(6).getText());
    }

    private boolean checkMiddleColumn() {
        if (buttons.get(1).getText().equals(this.initialString) || buttons.get(4).getText().equals(this.initialString) || buttons.get(7).getText().equals(this.initialString)) {
            return false;
        }

        return buttons.get(1).getText().equals(buttons.get(4).getText()) && buttons.get(4).getText().equals(buttons.get(7).getText());
    }

    private boolean checkTopLToBotRDiag() {
        if (buttons.get(0).getText().equals(this.initialString) || buttons.get(4).getText().equals(this.initialString) || buttons.get(8).getText().equals(this.initialString)) {
            return false;
        }

        return buttons.get(0).getText().equals(buttons.get(4).getText()) && buttons.get(4).getText().equals(buttons.get(8).getText());
    }

    private boolean checkBotLToTopRDiag() {

        if (buttons.get(6).getText().equals(this.initialString) || buttons.get(4).getText().equals(this.initialString) || buttons.get(2).getText().equals(this.initialString)) {
            return false;
        }

        return buttons.get(6).getText().equals(buttons.get(4).getText()) && buttons.get(4).getText().equals(buttons.get(2).getText());
    }
}
