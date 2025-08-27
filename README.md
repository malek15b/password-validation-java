## Passwortvalidierung

#### Muss-Kriterien (Basis):
- mindestens **8 Zeichen**,
- mindestens **eine Ziffer** (0–9),
- **Groß- und Kleinbuchstaben** (beides muss vorkommen),
- **nicht** in einer Liste häufiger/schwacher Passwörter.

#### Optional (Bonus-Policy):
- mindestens **ein Sonderzeichen** (definiere erlaubte Menge),
- Mindestanzahl unterschiedlicher Zeichengruppen (z. B. 3 von 4: Groß, Klein, Ziffer, Sonderzeichen).

#### Methodensignaturen:

```java
public final class PasswordValidator {
    public static boolean hasMinLength(String password, int min);
    public static boolean containsDigit(String password);
    public static boolean containsUpperAndLower(String password);
    public static boolean isCommonPassword(String password); // kleine interne Liste
    // Bonus:
    public static boolean containsSpecialChar(String password, String allowed);
    // Optionale Gesamtsicht:
    public static boolean isValid(String password); // nutzt die obenstehenden Checks
}
