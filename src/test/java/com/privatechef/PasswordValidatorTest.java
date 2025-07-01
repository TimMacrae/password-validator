package com.privatechef;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator("");
    }

    @Test
    void validate_isValidPassword() {
        passwordValidator.setPassword("!12WisheasdDALlkwq");
        String expect = "Valid Password";

        assertEquals(expect, passwordValidator.validate());
    }

    @Test
    void checkLength_isNotValid() {
        passwordValidator.setPassword("Short");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkLength()
        );
        assertEquals("Password length should be between 8 and 16 characters", ex.getMessage());
    }

    @Test
    void checkLength_doesNotThrow_whenValid() {
        passwordValidator.setPassword("ValidLength");
        assertDoesNotThrow(() -> passwordValidator.checkLength());
    }

    @Test
    void checkNumber_isNotValid() {
        passwordValidator.setPassword("NoNumber");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkNumber()
        );
        assertEquals("Password should have at least 1 number", ex.getMessage());
    }

    @Test
    void checkNumber_doesNotThrow_whenValid() {
        passwordValidator.setPassword("ValidNumber0");
        assertDoesNotThrow(() -> passwordValidator.checkNumber());
    }

    @Test
    void checkUppercaseLetters_isNotValid() {
        passwordValidator.setPassword("uppercaseletters");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkUppercaseLetters()
        );
        assertEquals("Password should have at least 1 uppercase letter", ex.getMessage());
    }

    @Test
    void checkUppercaseLetters_doesNotThrow_whenValid() {
        passwordValidator.setPassword("ValidUppercase");
        assertDoesNotThrow(() -> passwordValidator.checkUppercaseLetters());
    }

    @Test
    void checkLowercaseLetters_isNotValid() {
        passwordValidator.setPassword("LOWERCASELETTERS");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkLowercaseLetters()
        );
        assertEquals("Password should have at least 1 lower case letter", ex.getMessage());
    }

    @Test
    void checkLowercaseLetters_doesNotThrow_whenValid() {
        passwordValidator.setPassword("ValidLowercase");
        assertDoesNotThrow(() -> passwordValidator.checkLowercaseLetters());
    }

    @Test
    void checkWeekPassword_isNotValid() {
        passwordValidator.setPassword("password");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkWeekPassword()
        );
        assertEquals("Password is too weak", ex.getMessage());
    }

    @Test
    void checkWeekPassword_doesNotThrow_whenValid() {
        passwordValidator.setPassword("ValidLowercase012");
        assertDoesNotThrow(() -> passwordValidator.checkWeekPassword());
    }


    @Test
    void checkSpecialCharacters_isNotValid() {
        passwordValidator.setPassword("Password01");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkSpecialCharacters()
        );
        assertEquals("Password should have at least 1 special character", ex.getMessage());
    }

    @Test
    void checkSpecialCharacters_doesNotThrow_whenValid() {
        passwordValidator.setPassword("ValidSpecial!");
        assertDoesNotThrow(() -> passwordValidator.checkSpecialCharacters());
    }
}