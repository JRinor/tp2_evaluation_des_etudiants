package Login;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class Database {
    private Connection connection;

    public Database(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public ResultSet getResults() throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM Resultats");
    }

    public void insertProfessor(Professeur professeur, String email) throws SQLException {
        String hashedPassword = BCrypt.hashpw(professeur.getPassword(), BCrypt.gensalt());
        String query = "INSERT INTO Professeur (nom, password, mail) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, professeur.getUsername());
        preparedStatement.setString(2, hashedPassword);
        preparedStatement.setString(3, email);
        preparedStatement.executeUpdate();
    }

    public boolean validateProfessor(Professeur professeur) throws SQLException {
        String query = "SELECT * FROM Professeur WHERE nom = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, professeur.getUsername());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String storedPasswordHash = resultSet.getString("password");
            return BCrypt.checkpw(professeur.getPassword(), storedPasswordHash);
        }
        return false;
    }
}
