package Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez votre nom d'utilisateur : ");
        String username = scanner.nextLine();

        System.out.println("Entrez votre mot de passe : ");
        String password = scanner.nextLine();

        Professeur professeur = new Professeur(username, password);

        try {
            Database database = new Database("jdbc:h2:~/SchoolApp", "sa", "");

            if (database.validateProfessor(professeur)) {
                System.out.println("Vous êtes bien connecté.");

                ResultSet results = database.getResults();

                while (results.next()) {
                    System.out.println("ID: " + results.getInt("id"));
                    System.out.println("ID de l'étudiant: " + results.getInt("etudiant_id"));
                    System.out.println("ID du professeur: " + results.getInt("professeur_id"));
                    System.out.println("Date de l'examen: " + results.getDate("date_examen"));
                    System.out.println("Nombre de notes: " + results.getInt("nombre_notes"));
                    System.out.println("Notes: " + results.getString("notes"));
                    System.out.println("-------------------");
                }
            } else {
                System.out.println("Identifiants incorrects.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
