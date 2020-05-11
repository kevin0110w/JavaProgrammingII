
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!

    }

    public static void printKeys(HashMap<String, String> hashmap) {
        hashmap.keySet().forEach((key) -> {
            System.out.println(key);
        });
    }

    public static void printKeysWhere(HashMap<String, String> hashmap, String text) {
        hashmap.keySet().stream()
                .filter(key -> key.contains(text))
                .forEach(System.out::println);
    }
    
    public static void printValuesOfKeysWhere(HashMap<String, String> hashmap, String text) {
        hashmap.keySet().stream()
                .filter(key -> key.contains(text))
                .map(key -> hashmap.get(key))
                .forEach(System.out::println);
    }
}
