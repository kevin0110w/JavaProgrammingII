
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
        List<String> numbers = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String number = scanner.nextLine();
            if (number.equals("end")) {
                break;
            }
            numbers.add(number);
        }
        System.out.println();
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String command = scanner.nextLine();
        if (command.equals("n")) {
            System.out.println("Average of the negative numbers: " + numbers.stream().mapToInt(number -> Integer.valueOf(number)).filter(number -> number < 0).average().getAsDouble());
        } else {
            System.out.println("Average of the positive numbers: " + numbers.stream().mapToInt(number -> Integer.valueOf(number)).filter(number -> number >= 0).average().getAsDouble());
        }
    }
}
