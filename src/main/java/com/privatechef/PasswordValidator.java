package com.privatechef;

public class PasswordValidator {

    final String[]  weekPasswords = {"Password", "Password123"};
    String password;

    // Constructor & Setter
    PasswordValidator(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Validation
    public String validate() {
        return "Valid Password";
    }

    // Methods
    public void checkLength() {
        if (this.password == null || this.password.length() < 8 || this.password.length() > 16) {
            throw new IllegalArgumentException("Password length should be between 8 and 16 characters");
        }
    }

    public void checkNumber() {
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password should have at least 1 number");
        }
    }

    public void checkUppercaseLetters() {
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password should have at least 1 uppercase letter");
        }
    }

    public String checkLowercaseLetters() {
        return "Password should have at least 1 lower case letter";
    }

    public String checkWeekPassword() {
        return "Password is to week";
    }

    public String checkSpecialCharacters() {
        return "Password should have at least 1 special characters";
    }



}
