package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        View view = new View(model);

        Scene scene = new Scene(view.getLayout(), 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
