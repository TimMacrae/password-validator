package com.privatechef;

import java.util.Scanner;

public class Main {
    static final ExceptionMessages exceptionMessages = new ExceptionMessages();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type GENERATE to generate a password or OWN to type your own password");

        String decision = scanner.nextLine();
        if (decision.equals("OWN")) {
            validateUserPassword();
        }
        if(decision.equals("GENERATE")) {
            generateUserPassword();
        }


    }

    public static void validateUserPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your password:");

        String password = scanner.nextLine();
        PasswordValidator passwordValidator = new PasswordValidator(password);

        try {
            passwordValidator.validate();
            System.out.println(exceptionMessages.VALID_PASSWORD);
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid password: "+ ex.getMessage());
        }
    }

    public static void generateUserPassword(){
        PasswordValidator passwordValidator = new PasswordValidator("");
        String generatedPassword = passwordValidator.generatePassword();
        System.out.println("You password is: " + generatedPassword);
    }
}