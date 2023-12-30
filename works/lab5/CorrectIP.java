import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrectIP {
    public static void main(String[] args) {
        String text = "256.168.0.1";
        Pattern currentPattern = Pattern.compile("\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}");
        Matcher currentMatcher = currentPattern.matcher(text);
        Pattern correctPattern = Pattern.compile("\\b(25[0-5]|2[0-4][0-9]|[0-1][0-9]?[0-9]?){0,3}\\.(25[0-6]|2[0-4][0-9]|[0-1][0-9]?[0-9]?){0,3}\\." +
                                                        "(25[0-6]|2[0-4][0-9]|[0-1][0-9]?[0-9]?){0,3}\\.(25[0-6]|2[0-4][0-9]|[0-1][0-9]?[0-9]?){0,3}");
        Matcher correctMatcher = correctPattern.matcher(text);
        while (currentMatcher.find() && correctMatcher.find()) {
            if (correctMatcher.group().equals(currentMatcher.group())) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }

    }
}
