
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;
        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] inputs = input.split(" ");
            String command = inputs[0];
            int value = Integer.valueOf(inputs[1]);

            if (command.equals("add") && value > 0) {
                first += value;
                if (first > 100) {
                    first = 100;
                }
            } else if ((command.equals("move")) && value > 0) {
                int difference = 0;
                if (first >= value) {
                    first -= value;
                    second += value;
                } else {
                    second += first;
                    first = 0;
                }

                if (second > 100) {
                    second = 100;
                }
            } else if (command.equals("remove") && value > 0) {
                second -= value;
                if (second < 0) {
                    second = 0;
                }
            }
            System.out.println();
        }
    }

}
