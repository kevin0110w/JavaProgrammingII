package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {

    private Dictionary dictionary;
    private Statistics stats;

    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
        this.stats = new Statistics();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        PracticeView practiceView = new PracticeView(dictionary, stats);
        StatisticsView statisticsView = new StatisticsView(stats);
        InputView inputView = new InputView(dictionary);

        BorderPane layout = new BorderPane();

        // 3.1. Create the menu for the general layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        // 3.2. Create the menu buttons
        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");
        Button statisticsButton = new Button("See stats");

        // 3.3. Add the buttons to the menu
        menu.getChildren().addAll(enterButton, practiceButton, statisticsButton);
        layout.setTop(menu);

        // 4. Connect the subviews with the buttons. Clicking menu buttons changes the subview.
        enterButton.setOnAction((event) -> layout.setCenter(inputView.getView()));
        practiceButton.setOnAction((event) -> layout.setCenter(practiceView.getView()));
        statisticsButton.setOnAction((event) -> layout.setCenter(statisticsView.getLayout()));

        // 5. First show the input view
        layout.setCenter(inputView.getView());

        // 6. Create the main view and add the high level layout
        Scene view = new Scene(layout, 400, 300);

        // 7. Show the application
        stage.setScene(view);
        stage.show();
    }
}
