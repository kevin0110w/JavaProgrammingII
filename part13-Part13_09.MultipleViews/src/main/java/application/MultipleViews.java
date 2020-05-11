package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane sceneOneComponentGroup = new BorderPane();
        Label topLabel = new Label("First view!");
        Button button = new Button("To the second view!");

        sceneOneComponentGroup.setTop(topLabel);
        sceneOneComponentGroup.setCenter(button);
        
        Scene viewOne = new Scene(sceneOneComponentGroup);

        VBox sceneTwoComponentGroup = new VBox();
        Button buttonTwo = new Button("To the third view!");
        Label secondLabel = new Label("Second view!");

        sceneTwoComponentGroup.getChildren().addAll(buttonTwo, secondLabel);

        Scene viewTwo = new Scene(sceneTwoComponentGroup);

        GridPane sceneThreeComponentGroup = new GridPane();
        Label thirdLabel = new Label("Third view!");
        Button buttonThree = new Button("To the first view!");
        
        sceneThreeComponentGroup.add(thirdLabel, 0, 0);
        sceneThreeComponentGroup.add(buttonThree, 1, 1);
        
        Scene viewThree = new Scene(sceneThreeComponentGroup);
        
        button.setOnAction((event) -> {
            stage.setScene(viewTwo);
        });

        buttonTwo.setOnAction((event) -> {
            stage.setScene(viewThree);
        });
        
        buttonThree.setOnAction((event) -> {
            stage.setScene(viewOne);
        });

        stage.setScene(viewOne);
        stage.show();
    }

}
