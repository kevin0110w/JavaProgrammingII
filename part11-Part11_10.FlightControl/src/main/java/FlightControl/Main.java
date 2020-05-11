package FlightControl;

import FlightControl.domain.Model;
import FlightControl.logic.Controller;
import FlightControl.view.View;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        Scanner scanner = new Scanner(System.in);
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view, scanner);
        controller.start();
    }
}
