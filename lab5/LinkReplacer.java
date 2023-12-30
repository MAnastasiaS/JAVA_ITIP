import java.util.regex.*;

public class LinkReplacer {
    public static void main(String[] args) {
        String text = "Visit our website at http://www.example.com and check out our products.";
        Pattern pattern = Pattern.compile("(http[s]?:\\/\\/[\\S]+)");
        Matcher matcher = pattern.matcher(text);

        String replacedText = matcher.replaceAll("<a href=\"$1\">$1</a>");
        System.out.println(replacedText);
    }
}
