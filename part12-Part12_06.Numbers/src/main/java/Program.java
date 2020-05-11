
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("How many random numbers should be printed?");
        int randomNumbers = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < randomNumbers; i++) {
            System.out.println(rand.nextInt(11));
        }
    }

}
