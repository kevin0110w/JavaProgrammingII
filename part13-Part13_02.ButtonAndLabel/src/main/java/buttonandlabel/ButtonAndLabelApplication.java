package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Button buttonComponent = new Button("This is the button");
        Label labelComponent = new Label("This is the label");
        
        GridPane componentGroup = new GridPane();
        GridPane.setRowIndex(labelComponent, 0);
        GridPane.setRowIndex(buttonComponent, 1);
        componentGroup.getChildren().addAll(labelComponent, buttonComponent);
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
    }
}
