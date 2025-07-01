package com.privatechef;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    PasswordValidator passwordValidator;

    @BeforeEach
    void setUp(){
        passwordValidator =   new PasswordValidator("");
    }

    @Test
    void validate() {
        passwordValidator.setPassword("!12WisheasdDALlkwq");
        String expect =  "Valid Password";

        assertEquals(expect,passwordValidator.validate());
    }

    @Test
    void checkLength() {
        passwordValidator.setPassword("Short");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkLength()
        );
        assertEquals("Password length should be between 8 and 16 characters", ex.getMessage());
    }

    @Test
    void checkNumber() {
        passwordValidator.setPassword("NoNumber");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkNumber()
        );
        assertEquals("Password should have at least 1 number", ex.getMessage());
    }

    @Test
    void checkUppercaseLetters() {
        passwordValidator.setPassword("uppercaseletters");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkUppercaseLetters()
        );
        assertEquals("Password should have at least 1 uppercase letter", ex.getMessage());
    }

    @Test
    void checkLowercaseLetters() {
        passwordValidator.setPassword("LOWERCASELETTERS");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkLowercaseLetters()
        );
        assertEquals("Password should have at least 1 lower case letter", ex.getMessage());
    }

    @Test
    void checkWeekPassword() {
        passwordValidator.setPassword("password");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkWeekPassword()
        );
        assertEquals("Password length should be between 8 and 16 characters", ex.getMessage());
    }

    @Test
    void checkSpecialCharacters() {
        passwordValidator.setPassword("Password01");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                passwordValidator.checkSpecialCharacters()
        );
        assertEquals("Password length should be between 8 and 16 characters", ex.getMessage());
    }
}