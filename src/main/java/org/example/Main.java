package org.example;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            String pw = args[0];
            boolean isValid = PasswordValidator.isValid(pw);
            System.out.println(isValid ? "Passwort ist gültig" : "Passwort ist nicht gültig");
        } else {
            System.out.println("Bitte Passwort als Argument angeben.");
        }
    }
}