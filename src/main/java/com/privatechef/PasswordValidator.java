package com.privatechef;

public class PasswordValidator {
    final ExceptionMessages exceptionMessages = new ExceptionMessages();

    final String[]  weekPasswords = {"Password", "Password123", "Password1!","12345678"};
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
        for (String weak : this.weekPasswords) {
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

}
