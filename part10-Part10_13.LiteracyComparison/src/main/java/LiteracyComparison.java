
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        String filename = "literacy.csv";
        ArrayList<LiteracyLevel> literacyLevels = readFile(filename);
        literacyLevels.stream()
                .sorted()
                .forEach(literacyLevel -> System.out.println(literacyLevel));
                
    }

    public static ArrayList<LiteracyLevel> readFile(String file) {
        try {
            return Files.lines(Paths.get(file))
                    .map(line -> line.split(","))
                    .map(parts -> new LiteracyLevel(parts[3], Integer.valueOf(parts[4]), parts[2], Double.valueOf(parts[5])))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
