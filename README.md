## Passwortvalidierung

### Projektbeschreibung

Prüft Passwörter nach Länge, Ziffern, Groß-/Kleinbuchstaben, gängigen Passwörtern und Sonderzeichen.

#### Muss-Kriterien (Basis):
- mindestens **8 Zeichen**,
- mindestens **eine Ziffer** (0–9),
- **Groß- und Kleinbuchstaben** (beides muss vorkommen),
- **nicht** in einer Liste häufiger/schwacher Passwörter
- mindestens **ein Sonderzeichen**

#### Methodensignaturen:

```java
public final class PasswordValidator {
    public static boolean hasMinLength(String password, int min);
    public static boolean containsDigit(String password);
    public static boolean containsUpperAndLower(String password);
    public static boolean isCommonPassword(String password);
    public static boolean containsSpecialChar(String password, String allowed);
    public static boolean isValid(String password);
    public static String generateSecurePassword(int length, String allowedSpecials);
}
```
#### Build / Run / Tests:

- lokal: mvn clean verify
- Artefakt: mvn package → target/*.jar

![CI](https://github.com/malek15b/password-validation-java/actions/workflows/maven.yml/badge.svg)

#### Beispiel-Aufrufe:

```
boolean isValid = PasswordValidator.isValid("MyPass123!");
```
#### CLI:

```
java -jar target/PasswordValidator.jar MyPass123! (isValid)
```