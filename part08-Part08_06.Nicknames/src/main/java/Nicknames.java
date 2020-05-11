
import java.util.HashMap;
import java.util.Map;

public class Nicknames {
    
    public static void main(String[] args) {
        // Do the operations required here!
        Map<String, String> nicknames = new HashMap<>();
        
        nicknames.put("matthew", "matt");
        nicknames.put("michael", "mix");
        nicknames.put("arthur", "artie");
        
        System.out.println(nicknames.get("matthew"));
    }
    
}
