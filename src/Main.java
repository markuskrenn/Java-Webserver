import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This is just for tests...
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Path index = Path.of("res/index.html");
        String message = Files.readString(index);
        System.out.println(message);
    }
}
