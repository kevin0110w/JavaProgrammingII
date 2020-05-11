
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] commands = input.split(" ");
            String command = commands[0];
            int contents = Integer.valueOf(commands[1]);

            if (command.equals("remove")) {
                second.remove(contents);
            } else if (command.equals("add")) {
                first.add(contents);
            } else if (command.equals("move")) {
                int initialValue = first.contains();
                first.remove(contents);
                int eventualValue = first.contains();
                second.add(initialValue - eventualValue);
            }
            System.out.println("");

        }
    }

}
