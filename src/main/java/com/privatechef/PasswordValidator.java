package com.privatechef;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordValidator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIALS = "!@#$%^&*()_+-={}[]|:;<>,.?/";
    private static final String ALL_CHARS = UPPERCASE + LOWERCASE + DIGITS + SPECIALS;
    private static final String[] WEAK_PASSWORDS = {"password", "12345678", "qwerty", "Password1!"};

    private static final SecureRandom randomNumber = new SecureRandom();


    final ExceptionMessages exceptionMessages = new ExceptionMessages();
    private String password;


    // Constructor & Setter
    PasswordValidator(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Validation
    public String validate() {
        checkLength();
        checkNumber();
        checkUppercaseLetters();
        checkLowercaseLetters();
        checkWeekPassword();
        checkSpecialCharacters();
        // Add more test cases if needed
        return exceptionMessages.VALID_PASSWORD;
    }

    // Methods
    public void checkLength() {
        if (this.password == null || this.password.length() < 8 || this.password.length() > 16) {
            throw new IllegalArgumentException(exceptionMessages.CHECK_LENGTH);
        }
    }

    public void checkNumber() {
        if (!this.password.matches(".*\\d.*")) {
            throw new IllegalArgumentException(exceptionMessages.CHECK_NUMBER);
        }
    }

    public void checkUppercaseLetters() {
        if (!this.password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException(exceptionMessages.CHECK_UPPERCASE);
        }
    }

    public void checkLowercaseLetters() {
        if (!this.password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException(exceptionMessages.CHECK_LOWERCASE);
        }
    }

    public void checkWeekPassword() {
        for (String weak : WEAK_PASSWORDS) {
            if (this.password.equalsIgnoreCase(weak)) {
                throw new IllegalArgumentException(exceptionMessages.CHECK_IS_TO_WEEK);
            }
        }
    }

    public void checkSpecialCharacters() {
        if (!this.password.matches(".*[!@#$%^&*()_+\\-={}:\";'<>?,./].*")) {
            throw new IllegalArgumentException(exceptionMessages.CHECK_HAS_SPECIAL_CHAR);
        }
    }


    public String generatePassword() {
        while (true) {
            List<Character> passwordChar = new ArrayList<>();

            passwordChar.add(randomChar(UPPERCASE));
            passwordChar.add(randomChar(LOWERCASE));
            passwordChar.add(randomChar(DIGITS));
            passwordChar.add(randomChar(SPECIALS));

            for (int i = 4; i < 16; i++) {
                passwordChar.add(randomChar(ALL_CHARS));
            }

            Collections.shuffle(passwordChar);
            StringBuilder password = new StringBuilder();

            for (char c : passwordChar) {
                password.append(c);
            }

            this.password = password.toString();
            try {
                validate();
                break;
            } catch (IllegalArgumentException e) {
                System.err.println("Generated password failed validation: " + e.getMessage());
            }
        }
        return this.password;
    }

    private static char randomChar(String chars) {
        return chars.charAt(randomNumber.nextInt(chars.length()));
    }

}
