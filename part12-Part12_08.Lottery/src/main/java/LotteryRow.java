
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private final int TOTAL_NUMBER_OF_NUMBERS;
    private final int HIGHEST_NUMBER;
    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.TOTAL_NUMBER_OF_NUMBERS = 7;
        this.HIGHEST_NUMBER = 40;
        this.randomizeNumbers();

    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        Random rand = new Random();
        for (int i = 0; i < this.TOTAL_NUMBER_OF_NUMBERS; i++) {
            while (true) {
                int number = rand.nextInt(HIGHEST_NUMBER) + 1;
                if (!containsNumber(number)) {
                    numbers.add(number);
                    break;
                }
            }
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        return this.numbers.contains(number);
    }
}
