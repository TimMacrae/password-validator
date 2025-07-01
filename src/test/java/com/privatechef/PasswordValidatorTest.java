package com.privatechef;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    PasswordValidator passwordValidator;
    ExceptionMessages exceptionMessages = new ExceptionMessages();

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator("");
    }

    // Method validate
    @Test
    void validate_isValidPassword() {
        passwordValidator.setPassword("!12WisheasdDA");
        String expect = exceptionMessages.VALID_PASSWORD;

        assertEquals(expect, passwordValidator.validate());
    }

    @Test
    void validate_checkLength() {
        passwordValidator.setPassword("!12Wishasdqqwlksdas");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.validate()
        );
        assertEquals(exceptionMessages.CHECK_LENGTH, ex.getMessage());
    }

    @Test
    void validate_checkNumber() {
        passwordValidator.setPassword("!Wishasdqqwlk");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.validate()
        );
        assertEquals(exceptionMessages.CHECK_NUMBER, ex.getMessage());
    }

    @Test
    void validate_checkUppercaseLetters() {
        passwordValidator.setPassword("!0wishasdqqwlk");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.validate()
        );
        assertEquals(exceptionMessages.CHECK_UPPERCASE, ex.getMessage());
    }

    @Test
    void validate_checkLowercaseLetters() {
        passwordValidator.setPassword("!0ABCDEFG");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.validate()
        );
        assertEquals(exceptionMessages.CHECK_LOWERCASE, ex.getMessage());
    }

    @Test
    void validate_checkWeekPassword() {
        passwordValidator.setPassword("Password1!");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.validate()
        );
        assertEquals(exceptionMessages.CHECK_IS_TO_WEEK, ex.getMessage());
    }

    @Test
    void validate_checkHasSpecialCharacter() {
        passwordValidator.setPassword("Password1");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.validate()
        );
        assertEquals(exceptionMessages.CHECK_HAS_SPECIAL_CHAR, ex.getMessage());
    }


    // Method checkLength
    @Test
    void checkLength_isNotValid_throwsException() {
        passwordValidator.setPassword("Short");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkLength()
        );
        assertEquals(exceptionMessages.CHECK_LENGTH, ex.getMessage());
    }

    @Test
    void checkLength_isValid_doesNotThrowException() {
        passwordValidator.setPassword("ValidLength");
        assertDoesNotThrow(() -> passwordValidator.checkLength());
    }

    // Method checkNumber
    @Test
    void checkNumber_isNotValid_throwsException() {
        passwordValidator.setPassword("NoNumber");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkNumber()
        );
        assertEquals(exceptionMessages.CHECK_NUMBER, ex.getMessage());
    }

    @Test
    void checkNumber_isValid_doesNotThrowException() {
        passwordValidator.setPassword("ValidNumber0");
        assertDoesNotThrow(() -> passwordValidator.checkNumber());
    }

    // Method checkUppercaseLetters
    @Test
    void checkUppercaseLetters_isNotValid_throwsException() {
        passwordValidator.setPassword("uppercaseletters");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkUppercaseLetters()
        );
        assertEquals(exceptionMessages.CHECK_UPPERCASE, ex.getMessage());
    }

    @Test
    void checkUppercaseLetters_isValid_doesNotThrowException() {
        passwordValidator.setPassword("ValidUppercase");
        assertDoesNotThrow(() -> passwordValidator.checkUppercaseLetters());
    }

    // Method checkLowercaseLetters
    @Test
    void checkLowercaseLetters_isNotValid_throwsException() {
        passwordValidator.setPassword("LOWERCASELETTERS");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkLowercaseLetters()
        );
        assertEquals(exceptionMessages.CHECK_LOWERCASE, ex.getMessage());
    }

    @Test
    void checkLowercaseLetters_isValid_doesNotThrowException() {
        passwordValidator.setPassword("ValidLowercase");
        assertDoesNotThrow(() -> passwordValidator.checkLowercaseLetters());
    }

    // Method checkWeekPassword
    @Test
    void checkWeekPassword_isNotValid_throwsException() {
        passwordValidator.setPassword("password");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkWeekPassword()
        );
        assertEquals(exceptionMessages.CHECK_IS_TO_WEEK, ex.getMessage());
    }

    @Test
    void checkWeekPassword_isValid_doesNotThrowException() {
        passwordValidator.setPassword("ValidLowercase012");
        assertDoesNotThrow(() -> passwordValidator.checkWeekPassword());
    }

    // Method checkSpecialCharacters
    @Test
    void checkSpecialCharacters_isNotValid_throwsException() {
        passwordValidator.setPassword("Password01");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkSpecialCharacters()
        );
        assertEquals(exceptionMessages.CHECK_HAS_SPECIAL_CHAR, ex.getMessage());
    }

    @Test
    void checkSpecialCharacters_isValid_doesNotThrowException() {
        passwordValidator.setPassword("ValidSpecial!");
        assertDoesNotThrow(() -> passwordValidator.checkSpecialCharacters());
    }
}