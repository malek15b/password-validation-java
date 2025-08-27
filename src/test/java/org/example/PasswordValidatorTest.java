package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void hasMinLength_ShouldReturnTrueWhenPasswordGreaterThanMinLength() {
        //Given
        int minLength = 8;
        String password = "123456789";
        //When
        boolean hasMinLength = PasswordValidator.hasMinLength(password, minLength);
        //Then
        assertTrue(hasMinLength);
    }

    @Test
    public void hasMinLength_ShouldReturnTrueWhenPasswordEqualsMinLength() {
        //Given
        int minLength = 8;
        String password = "12345678";
        //When
        boolean hasMinLength = PasswordValidator.hasMinLength(password, minLength);
        //Then
        assertTrue(hasMinLength);
    }

    @Test
    public void hasMinLength_ShouldReturnTrueWhenPasswordLessThanMinLength() {
        //Given
        int minLength = 8;
        String password = "1234567";
        //When
        boolean hasMinLength = PasswordValidator.hasMinLength(password, minLength);
        //Then
        assertFalse(hasMinLength);
    }

    @Test
    public void hasMinLength_ShouldReturnFalseWhenPasswordIsNull() {
        //Given
        int length = 8;
        //Then
        assertFalse(PasswordValidator.hasMinLength(null, length));
    }

    @Test
    public void hasMinLength_ShouldReturnFalseWhenPasswordIsEmpty() {
        //Given
        int length = 8;
        String password = "";
        //Then
        assertFalse(PasswordValidator.hasMinLength(password, length));
    }

    @Test
    public void containsDigit_ShouldReturnFalseWhenPasswordHasOneDigit() {
        //Given
        String password = "abcdef5ghijklmn";
        //Then
        assertTrue(PasswordValidator.containsDigit(password));
    }

    @Test
    public void containsDigit_ShouldReturnTrueWhenPasswordHasUpperCase() {
        //Given
        String password = "abcdUf5ghijKlmn";
        //Then
        assertTrue(PasswordValidator.containsUpperAndLower(password));
    }

    @Test
    public void isCommonPassword_ShouldReturnTrueWhenPasswordEqualsPassword() {
        //Given
        String password = "PasSworD";
        //Then
        assertTrue(PasswordValidator.isCommonPassword(password));
    }

    @Test
    public void containsSpecialChar_ShouldReturnFalseWhenPasswordNotContainsSpecialChar() {
        //Given
        String password = "PasSworD";
        String specialChars = "()-_+=?.,;:";
        //Then
        assertFalse(PasswordValidator.containsSpecialChar(password, specialChars));
    }

    @Test
    public void generateSecurePassword_ShouldBeValid() {
        //Given
        String password = PasswordValidator.generateSecurePassword(12);
        //Then
        assertTrue(PasswordValidator.isValid(password), password);
    }

    @Test
    public void isValid_ShouldBeSuccess() {
        assertFalse(PasswordValidator.isValid("Abc1ef!"), "Min-Länge fail");
        assertTrue(PasswordValidator.isValid("Abc1defg!"), "Min-Länge ok");
        assertFalse(PasswordValidator.isValid("Abcdefgh!"), "Keine Ziffer");
        assertFalse(PasswordValidator.isValid("abcdefg1!"), "Nur Kleinbuchstaben");
        assertFalse(PasswordValidator.isValid("ABCDEFG1!"), "Nur Großbuchstaben");
        assertFalse(PasswordValidator.isValid("Passwort1"), "Häufiges Passwort");
        assertTrue(PasswordValidator.isValid("Abcdef1g!"), "Gültig (Basis)");
        assertFalse(PasswordValidator.isValid("Abcdef1g"), "Sonderzeichen fail");
    }

}