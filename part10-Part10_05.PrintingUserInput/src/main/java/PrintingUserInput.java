
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while (true) {
            String command = scanner.nextLine();
            if (command.isEmpty()) {
                break;
            }
            inputs.add(command);
        }
        System.out.println();
        inputs.stream()
                .forEach(input -> System.out.println(input));
    }
}
