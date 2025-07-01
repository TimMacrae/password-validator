package com.privatechef;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExceptionMessages exceptionMessages = new ExceptionMessages();


        String password = getPasswordInput();
        PasswordValidator passwordValidator = new PasswordValidator(password);
        try {
            passwordValidator.validate();
            System.out.println(exceptionMessages.VALID_PASSWORD);
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid password: "+ ex.getMessage());
        }
    }

    public static String getPasswordInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your password:");
        return scanner.nextLine();
    }
}