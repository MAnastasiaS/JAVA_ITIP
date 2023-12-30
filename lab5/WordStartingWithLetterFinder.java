import java.util.regex.*;

public class WordStartingWithLetterFinder {
    public static void main(String[] args) {
        String text = "Java is a programming language. It's widely used for web development.";
        String letter = "w"; // Заданная буква
        Pattern pattern = Pattern.compile("\\b" + letter + "\\w*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
