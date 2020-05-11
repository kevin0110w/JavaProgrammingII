package title;

import java.util.Scanner;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter a title: ");
        String title = s.nextLine();
        Application.launch(UserTitle.class, "--title=" + title);

    }

}
