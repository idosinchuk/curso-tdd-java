package password_validation;

public class PasswordValidator {

    static boolean isValid(String password) {
        return validSize(password) && hasCapital(password) && hasLowerCase(password) && hasNumber(password)
                && hasUnderscore(password);
    }

    private static boolean validSize(String password) {
        return password != null && password.length() > 8;
    }

    private static boolean hasCapital(String password) {
        return !password.equals(password.toLowerCase());
    }

    private static boolean hasLowerCase(String password) {
        return !password.equals(password.toUpperCase());
    }

    private static boolean hasNumber(String password) {
        return password.matches(".*\\d.*");
    }

    private static boolean hasUnderscore(String password) {
        return password.contains("_");
    }


}
