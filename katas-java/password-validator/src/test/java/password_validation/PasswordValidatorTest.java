package password_validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorTest {

    @Test
    void valid_password_with_all_matching_criteria() {
        assertTrue(PasswordValidator.isValid("Cc_456789"));
    }

    @Test
    void password_is_invalid_if_it_contains_8_chars_or_less() {
        assertFalse(PasswordValidator.isValid("Cc_45678"));
    }

    @Test
    void password_is_invalid_if_it_contains_no_uppercase_chars() {
        assertFalse(PasswordValidator.isValid("cc_456789"));
    }

    @Test
    void password_is_invalid_if_it_contains_no_lowercase_chars() {
        assertFalse(PasswordValidator.isValid("CC_456789"));
    }

    @Test
    void password_is_invalid_if_it_contains_no_underscore() {
        assertFalse(PasswordValidator.isValid("Cc3456789"));
    }

    @Test
    void password_is_invalid_if_it_contains_no_digits() {
        assertFalse(PasswordValidator.isValid("Ccc_ccC__"));
    }
}