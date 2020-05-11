package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        Player[] players = new Player[]{new Player("X"), new Player("O")};
        model.setPlayers(players);

        View view = new View(model);
        
        Scene scene = new Scene(view.getLayout());
        stage.setScene(scene);
        stage.show();
    }

}
