import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrectPassword {
    public static void main(String[] args) {
        String password = "Qwertyqqqqqqq1";
        Pattern pattern = Pattern.compile("[A-Za-z0-9]{8,16}$");
        Matcher matcher = pattern.matcher(password);
        while (matcher.find()) {
            if (password.matches(".*[A-Z].*") && password.matches(".*\\d+.*")) {
                System.out.println("ok");
            }
            else {
                System.out.println("incorrect");
            }
        }
    }
}
