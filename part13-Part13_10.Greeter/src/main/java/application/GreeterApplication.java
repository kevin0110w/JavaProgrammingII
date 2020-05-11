package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public static void main(String[] args) {
        launch(GreeterApplication.class);
        System.out.println("Hellow world! :3");
    }

    @Override
    public void start(Stage window) throws Exception {
        // 1. We create a view for asking for a name

        // 1.1  We create the components needed
        Label instructionText = new Label("Enter your name and start.");
        TextField textField = new TextField();
        Button button = new Button("Start");

        // 1.2 We create a layout and add the components to it
        GridPane layout = new GridPane();

        layout.add(instructionText, 0, 0);
        layout.add(textField, 0, 1);
        layout.add(button, 0, 2);

        // 1.3 Styling the layout
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        String name = "";

        // 1.4 Creating the view and setting the layout to it
        Scene nameView = new Scene(layout);

        // 2. Creating the view for the welcome text
        Label welcomeText = new Label();

        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);

        Scene welcomeView = new Scene(welcomeLayout);

        // 3. Adding an event handler to the button on the name screen
        //   the view is changed once button clicked with welcoming message to 
        // user
        button.setOnAction((event) -> {
            welcomeText.setText("Welcome " + textField.getText() + "!");
            window.setScene(welcomeView);
        });

        window.setScene(nameView);
        window.show();

    }
}
