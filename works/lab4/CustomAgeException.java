import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CustomAgeException extends Exception {
    CustomAgeException(String message) {
        super(message);
        loggError(message);
    }
    public static void loggError(String error) {
        File log = new File("errors.txt");
        try {
            FileWriter writer = new FileWriter(log, true);
            writer.write(error + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
