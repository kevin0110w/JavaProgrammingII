package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        // 1. Creating the higher level layout
        BorderPane layout = new BorderPane();

        // 1.1. Creating the menu for the higher level's layout
        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        // 1.2. Creating the layout's buttons
        Button joke = new Button("Joke");
        Button answer = new Button("Answer");
        Button explanation = new Button("Explanation");

        // 1.3. Adding the buttons to the menu
        menu.getChildren().addAll(joke, answer, explanation);

        layout.setTop(menu);

        // 2. Creating the sub-views and connecting them to the menu buttons
        // 2.1. Creating the sub-views-- here are the layouts
        StackPane firstLayout = createView("What do you call a bear with no teeth?");
        StackPane secondLayout = createView("A gummy bear.");
        StackPane thirdLayout = createView("Nae teeth, all gums!");
        
        // 2.2. Connecting the sub-views to the buttons. Pressing a button changes the sub-view.
        joke.setOnAction((event) -> layout.setCenter(firstLayout));
        answer.setOnAction((event) -> layout.setCenter(secondLayout));
        explanation.setOnAction((event) -> layout.setCenter(thirdLayout));

        // 2.3. Displaying the first layout initially.
        layout.setCenter(firstLayout);

        // 3. Creating the main view and setting the higher-level layout in it
        Scene view = new Scene(layout);

        // 4. Displaying the application
        window.setScene(view);
        window.show();
    }

    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
