public class AgeChecker {
    public static void checkAge(int age) throws CustomAgeException {
        if (age < 0 || age > 60) {
            throw new CustomAgeException("Недопустимый возраст");
        }
        System.out.println("Возраст проверен успешно");
    }

    public static void main(String[] args) {
        int age = 60;
        try {
            checkAge(age);
        } catch (CustomAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
