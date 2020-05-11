package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class BorderPaneApplication extends Application {


    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane componentGroup = new BorderPane();
        
        componentGroup.setTop(new Label("NORTH"));
        componentGroup.setRight(new Label("EAST"));
        componentGroup.setBottom(new Label("SOUTH"));
        
        Scene view = new Scene(componentGroup);
        
        stage.setScene(view);
        stage.show();
    }

}
