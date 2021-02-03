package password_validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static password_validation.PasswordValidator.isValid;

class PasswordValidatorTest {

    @Test
    void should_return_false_when_null() {
        assertFalse(isValid(null));
    }

    @Test
    void should_return_true_when_valid_password() {
        assertTrue(isValid("12345678_Ab"));
    }

    // Have more than 8 characters
    // 12345678_Ab
    @Test
    void should_return_false_when_length_less_then_8() {
        assertFalse(isValid("1234_Ab"));
    }

    // Contains a capital letter
    // 12345678_ab
    @Test
    void should_return_false_when_is_not_capital_letter() {
        assertFalse(isValid("12345678_ab"));
    }

    // Contains a lowercase
    // 12345678_AB
    @Test
    void should_return_false_when_not_contains_lowercase() {
        assertFalse(isValid("12345678_AB"));
    }

    // Contains a number
    // ABCDEFGH_Ij
    @Test
    void should_return_false_when_not_contains_number() {
        assertFalse(isValid("ABCDEFGH_Ij"));
    }

    // Contains an underscore
    // 12345678Abc
    @Test
    void should_return_false_when_not_contains_underscore() {
        assertFalse(isValid("12345678Abc"));
    }

}
