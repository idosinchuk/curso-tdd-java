package password_validation;

import java.util.List;
import java.util.function.Predicate;

public class PasswordValidator {

    private static final List<Predicate<String>> rules = List.of(
            PasswordValidator::moreThan8Chars,
            PasswordValidator::containsUpperCaseChars,
            PasswordValidator::containsLowerCaseChars,
            PasswordValidator::containsUnderscore,
            PasswordValidator::containsDigits
    );

    public static boolean isValid(String password) {
        return rules.stream().allMatch(f -> f.test(password));
    }

    private static boolean moreThan8Chars(String password) {
        return password.length() > 8;
    }

    private static boolean containsLowerCaseChars(String password) {
        return !password.toUpperCase().equals(password);
    }

    private static boolean containsUpperCaseChars(String password) {
        return !password.toLowerCase().equals(password);
    }

    private static boolean containsUnderscore(String password) {
        return password.contains("_");
    }

    private static boolean containsDigits(String password) {
        return password.chars().anyMatch(Character::isDigit);
    }
}