import java.util.regex.*;

public class PasswordChecker {
    public static void main(String[] args) {
        String password = "P@ssw0rd"; // Пароль для проверки
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}$");
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            System.out.println("Пароль корректен");
        } else {
            System.out.println("Пароль некорректен");
        }
    }
}
