package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application {


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Canvas paintingCanvas = new Canvas(640, 480);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        
        BorderPane layout = new BorderPane();
        layout.setCenter(paintingCanvas);
        
        paintingCanvas.setOnMouseDragged((event) -> { 
            double xLocation = event.getX();
            double yLocation = event.getY();
            painter.setFill(Color.BLACK);
            painter.fillRect(yLocation, yLocation, 4, 4);
        });
        
        
        drawFace(painter);
        Scene view = new Scene(layout);
        
        stage.setScene(view);
        stage.show();
        
    }

    private void drawFace(GraphicsContext painter) {
            painter.setFill(Color.BLACK);
            painter.fillRect(100, 300, 50, 50);
            painter.fillRect(150, 100, 50, 50);
            painter.fillRect(150, 350, 150, 50);
            painter.fillRect(250, 100, 50, 50);
            painter.fillRect(300, 300, 50, 50);
            
    }

}
