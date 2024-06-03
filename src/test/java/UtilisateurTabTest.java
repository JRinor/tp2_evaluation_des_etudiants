import org.junit.Test;
import utilisateur.UtilisateurTab;

import static org.junit.Assert.*;

public class UtilisateurTabTest {

    @Test
    public void testValidateEmail() {
        assertTrue(UtilisateurTab.validateEmail("rinor@gmail.com"));
        assertFalse(UtilisateurTab.validateEmail("invalid email"));
    }

    @Test
    public void testStringBuilder() {
        UtilisateurTab utilisateur = new UtilisateurTab("Rinor", "Januzi", "rinor@gmail.com", "01/01/2024");
        String expected = "Prénom: Rinor\nNom: Januzi\nEmail: rinor@gmail.com\nDate d'examen: 01/01/2024\n";
        assertEquals(expected, utilisateur.StringBuilder());
    }
}