package com.privatechef;

public class PasswordValidator {

    final String[]  weekPasswords = {"Password", "Password123"};
    String password;

    // Set password
    PasswordValidator(String password) {
        this.password = password;
    }

    // Validation
    public String validate() {
        return "Valid";
    }

    // Methods
    public String checkLength() {
        return "Password length should be between 8 and 16 characters";
    }

    public String checkNumber() {
        return "Password should have at least 1 number";
    }

    public String checkUppercaseLetters() {
        return "Password should have at least 1 uppercase letter";
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
