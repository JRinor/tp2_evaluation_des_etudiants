package Login;

import Login.Database;
import Login.Professeur;
import Login.ResultsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.regex.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    public LoginFrame() {
        setTitle("Connexion");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nom d'utilisateur :"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Mot de passe :"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Connexion");
        panel.add(loginButton);

        statusLabel = new JLabel("");
        panel.add(statusLabel);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Vérifier si le nom d'utilisateur est valide
                if (!isValidUsername(username)) {
                    statusLabel.setText("Nom d'utilisateur invalide.");
                    return;
                }

                // Vérifier si le mot de passe est valide
                if (!isValidPassword(password)) {
                    statusLabel.setText("Mot de passe invalide.");
                    return;
                }

                Professeur professeur = new Professeur(username, password);

                try {
                    Database database = new Database("jdbc:h2:~/SchoolApp", "sa", "");

                    if (database.validateProfessor(professeur)) {
                        statusLabel.setText("Vous êtes bien connecté.");
                        openResultsFrame(database);
                    } else {
                        statusLabel.setText("Identifiants incorrects.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    statusLabel.setText("Erreur de connexion à la base de données.");
                }
            }
        });
    }

    private boolean isValidUsername(String username) {
        String usernamePattern = "^[a-zA-Z0-9]{5,}$";
        return Pattern.matches(usernamePattern, username);
    }

    private boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        return Pattern.matches(passwordPattern, password);
    }

    private void openResultsFrame(Database database) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ResultsFrame(database).setVisible(true);
            }
        });
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
