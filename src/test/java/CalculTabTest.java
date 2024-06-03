import org.junit.Test;
import static org.junit.Assert.*;
import calcultableau.CalculTab;

public class CalculTabTest {

    @Test
    public void testAjouterNote() {
        CalculTab calcul = new CalculTab();
        double addedNote = calcul.ajouterNote(10);
        assertEquals(10.0, addedNote, 0.01);
        assertEquals(1, calcul.getNombreEtudiants());
    }

    @Test
    public void testGetMoyenne() {
        CalculTab calcul = new CalculTab();
        calcul.ajouterNote(10);
        calcul.ajouterNote(20);
        assertEquals(15.0, calcul.getMoyenne(), 0.01);
    }

    @Test
    public void testGetNombreEtudiants() {
        CalculTab calcul = new CalculTab();
        calcul.ajouterNote(10);
        calcul.ajouterNote(20);
        assertEquals(2, calcul.getNombreEtudiants());
    }

    @Test
    public void testGetMediane() {
        CalculTab calcul = new CalculTab();
        calcul.ajouterNote(10);
        calcul.ajouterNote(20);
        assertEquals(15.0, calcul.getMediane(), 0.01);
    }

    @Test
    public void testGetMedianeWithOddNumberOfNotes() {
        CalculTab calcul = new CalculTab();
        calcul.ajouterNote(10);
        calcul.ajouterNote(20);
        calcul.ajouterNote(30);
        assertEquals(20.0, calcul.getMediane(), 0.01);
    }

    @Test
    public void testGetMedianeWithEvenNumberOfNotes() {
        CalculTab calcul = new CalculTab();
        calcul.ajouterNote(10);
        calcul.ajouterNote(20);
        calcul.ajouterNote(30);
        calcul.ajouterNote(40);
        assertEquals(25.0, calcul.getMediane(), 0.01);
    }

    @Test
    public void testGetMedianeWithNoNotes() {
        CalculTab calcul = new CalculTab();
        assertEquals(0.0, calcul.getMediane(), 0.01);
    }

    @Test
    public void testStringBuilder() {
        CalculTab calcul = new CalculTab();
        calcul.ajouterNote(10);
        calcul.ajouterNote(20);
        String expected = "Nombre d'étudiants: 2\nMoyenne: 15.0\nMediane: 15.0\n";
        assertEquals(expected, calcul.StringBuilder());
    }
}