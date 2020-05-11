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
        BorderPane componentGroup = new BorderPane();
        TextArea textArea = new TextArea();
        componentGroup.setCenter(textArea);
        
        HBox secondaryGroup = new HBox();
        Label label1 = new Label("Letters: ");
        Label label2 = new Label("Words: ");
        Label label3 = new Label("The longest word is: ");
        secondaryGroup.getChildren().addAll(label1, label2, label3);
        componentGroup.setBottom(secondaryGroup);
        
        textArea.textProperty().addListener((change, oldvalue, newvalue) -> {
            int characterCount = newvalue.length();
            String[] words = newvalue.split(" ");
            int wordCount = words.length;
            String longestWord = words[0];
            for (String aWord : words) {
                if (aWord.length() > longestWord.length()) {
                    longestWord = aWord;
                }
            }
            label1.setText("Letters: " + characterCount);
            label2.setText("Words: " + wordCount);
            label3.setText("The longest word is: " + longestWord);
        });
        Scene view = new Scene(componentGroup);
        stage.setScene(view);
        stage.show();
    }
    
}
