package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane componentGroup = new FlowPane();
        TextField textField = new TextField("This is the text field");
        Button button = new Button("Submit");
        
        componentGroup.getChildren().add(textField);
        componentGroup.getChildren().add(button);
        
        Scene view = new Scene(componentGroup);
        
        stage.setScene(view);
        stage.show();
    }

}
