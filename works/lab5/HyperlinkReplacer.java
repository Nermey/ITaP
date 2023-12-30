import java.util.regex.*;

public class HyperlinkReplacer {
    public static void main(String[] args) {
        String text = "Ссылка на www.vk.com так же ссылка на www.google.com";
        Pattern pattern = Pattern.compile("\\bwww\\.[A-Za-z0-9]+\\.[a-z]{2,3}");
        Matcher linkMatcher = pattern.matcher(text);
        while (linkMatcher.find()) {
            String link = "https://" + linkMatcher.group();
            text = text.replace(linkMatcher.group(), link);
        }
        System.out.println(text);
    }
}
