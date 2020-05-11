package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();
        int newXCoordinate = 0;
        int newYCoordinate = 0;
        int yCoordinate = 0;
        while (yCoordinate * 2 < height) {
            newYCoordinate = yCoordinate * 2;
            int xCoordinate = 0;
            while (xCoordinate * 2 < width) {
                newXCoordinate = xCoordinate * 2;
                int newX = xCoordinate + (width / 2);
                int newY = yCoordinate + (height / 2);
                Color color = imageReader.getColor(newXCoordinate, newYCoordinate);

                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                imageWriter.setColor(xCoordinate, yCoordinate, newColor);
                imageWriter.setColor(newX, yCoordinate, newColor);
                imageWriter.setColor(xCoordinate, newY, newColor);
                imageWriter.setColor(newX, newY, newColor);
                xCoordinate++;
            }

            yCoordinate++;

        }

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(CollageApplication.class);
    }

}
