import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalLetterFinder {
    public static void main(String[] args) {
        String text = "Qwe qwe Rty rty QWERT qQw qwE";
        Pattern pattern = Pattern.compile("\\b[A-Z]\\w+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
