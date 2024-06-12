package Login;

import java.sql.SQLException;

public class DataInitializer {
    public static void main(String[] args) {
        try {
            Database database = new Database("jdbc:h2:~/SchoolApp", "sa", "");
            Professeur professeur = new Professeur("rinor", "password123");
            database.insertProfessor(professeur, "dupont@example.com");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
