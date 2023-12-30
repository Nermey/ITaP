import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "re6sponsibility Wit10h gr5eat power3 430052 4comes g2reat\") ➞ " +
                "\" With great power comes great 10.2 responsibility 52,52";
        Pattern pattern = Pattern.compile("(\\d+[.,]\\d+)|(\\d+)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}