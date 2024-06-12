import Login.Database;
import Login.Professeur;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    @Test
    void testInsertProfessor() {
        try {
            Database database = new Database("jdbc:h2:~/SchoolApp", "sa", "");
            Professeur professeur = new Professeur("testUsername", "testPassword");
            database.insertProfessor(professeur, "testEmail");

            // Vérifiez si le professeur a été correctement inséré
            assertTrue(database.validateProfessor(professeur));
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exception lors de l'insertion du professeur");
        }
    }
}