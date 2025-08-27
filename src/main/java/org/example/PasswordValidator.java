package org.example;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PasswordValidator {

    static final Set<String> commonPasswords =
            new HashSet<>(Arrays.asList("password", "Passwort1", "12345678", "Aa345678"));

    static final int minLength = 8;
    static final String specialChars = "!@#$%^&*()-_+=?.,;:";

    private static final String letters = "abcdefghijklmnopqrstuvwxyz";
    private static final String digits = "0123456789";

    private static final String ALL = specialChars + letters + digits;

    public static boolean hasMinLength(String password, int min) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return password.length() >= min;
    }

    public static boolean containsDigit(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpper(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsLower(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpperAndLower(String password) {
        return containsUpper(password) && containsLower(password);
    }

    public static boolean isCommonPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        for (String commonPassword : commonPasswords) {
            if (password.trim().equalsIgnoreCase(commonPassword.trim())) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSpecialChar(String password, String allowed) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        for (char c : password.toCharArray()) {
            if (allowed.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(String password) {
        return hasMinLength(password, minLength)
                && containsDigit(password)
                && containsUpperAndLower(password)
                && !isCommonPassword(password)
                && containsSpecialChar(password, specialChars);
    }

    public static String generateSecurePassword(int length, String allowedSpecials) {
        SecureRandom secureRandom = new SecureRandom();
        String password = "";
        for (int i = 0; i < length; i++) {
            password += allowedSpecials.charAt(secureRandom.nextInt(allowedSpecials.length()));
        }
        return password;
    }

    public static String generateSecurePassword(int length) {
        String all = letters.toUpperCase() + ALL;
        return generateSecurePassword(length, all);
    }
}
