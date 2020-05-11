package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainComponentGroup = new BorderPane();
        mainComponentGroup.setCenter(new TextArea());
        
        HBox secondaryComponentGroup = new HBox();
        secondaryComponentGroup.getChildren().add(new Label("Letters: 0"));
        secondaryComponentGroup.getChildren().add(new Label("Words: 0"));
        secondaryComponentGroup.getChildren().add(new Label("The longest word is:"));
        
        mainComponentGroup.setBottom(secondaryComponentGroup);
        
        Scene view = new Scene(mainComponentGroup);
        
        stage.setScene(view);
        stage.show();
    }

}
