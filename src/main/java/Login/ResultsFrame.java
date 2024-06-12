package Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultsFrame extends JFrame {
    private JTable resultsTable;
    private JTextField etudiantIdField;
    private JTextField professeurIdField;
    private JTextField dateExamenField;
    private JTextField nombreNotesField;
    private JTextField notesField;
    private JButton addButton, modifyButton, deleteButton;
    private Database database;
    private DefaultTableModel tableModel;

    public ResultsFrame(Database database) {
        this.database = database;
        setTitle("Résultats");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"ID", "ETUDIANT_ID", "PROFESSEUR_ID", "DATE_EXAMEN", "NOMBRE_NOTES", "NOTES"};
        tableModel = new DefaultTableModel(columnNames, 0);
        resultsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(resultsTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));

        inputPanel.add(new JLabel("ID de l'étudiant:"));
        etudiantIdField = new JTextField();
        inputPanel.add(etudiantIdField);

        inputPanel.add(new JLabel("ID du professeur:"));
        professeurIdField = new JTextField();
        inputPanel.add(professeurIdField);

        inputPanel.add(new JLabel("Date de l'examen (YYYY-MM-DD):"));
        dateExamenField = new JTextField();
        inputPanel.add(dateExamenField);

        inputPanel.add(new JLabel("Nombre de notes:"));
        nombreNotesField = new JTextField();
        inputPanel.add(nombreNotesField);

        inputPanel.add(new JLabel("Notes:"));
        notesField = new JTextField();
        inputPanel.add(notesField);

        addButton = new JButton("Ajouter");
        inputPanel.add(addButton);

        modifyButton = new JButton("Modifier");
        inputPanel.add(modifyButton);

        deleteButton = new JButton("Supprimer");
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.SOUTH);

        loadResults();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addResult();
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyResult();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteResult();
            }
        });
    }

    private void loadResults() {
        try {
            ResultSet results = database.getResults();
            while (results.next()) {
                Object[] rowData = {
                        results.getInt("id"),
                        results.getInt("etudiant_id"),
                        results.getInt("professeur_id"),
                        results.getDate("date_examen"),
                        results.getInt("nombre_notes"),
                        results.getString("notes")
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des résultats.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void addResult() {
            try {
                int etudiantId = Integer.parseInt(etudiantIdField.getText());
                int professeurId = Integer.parseInt(professeurIdField.getText());
                String dateExamen = dateExamenField.getText();
                int nombreNotes = Integer.parseInt(nombreNotesField.getText());
                String notes = notesField.getText();

                String query = "INSERT INTO Resultats (etudiant_id, professeur_id, date_examen, nombre_notes, notes) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = database.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, etudiantId);
                preparedStatement.setInt(2, professeurId);
                preparedStatement.setDate(3, java.sql.Date.valueOf(dateExamen));
                preparedStatement.setInt(4, nombreNotes);
                preparedStatement.setString(5, notes);
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int lastInsertedId = generatedKeys.getInt(1);
                    Object[] rowData = {lastInsertedId, etudiantId, professeurId, dateExamen, nombreNotes, notes};
                    tableModel.addRow(rowData);
                }

                etudiantIdField.setText("");
                professeurIdField.setText("");
                dateExamenField.setText("");
                nombreNotesField.setText("");
                notesField.setText("");
                JOptionPane.showMessageDialog(this, "Résultat ajouté avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException | NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout du résultat.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void modifyResult() {
            int selectedRow = resultsTable.getSelectedRow();
            if (selectedRow != -1) {
                try {
                    int id = (int) tableModel.getValueAt(selectedRow, 0);
                    int etudiantId = Integer.parseInt(etudiantIdField.getText());
                    int professeurId = Integer.parseInt(professeurIdField.getText());
                    String dateExamen = dateExamenField.getText();
                    int nombreNotes = Integer.parseInt(nombreNotesField.getText());
                    String notes = notesField.getText();

                    String query = "UPDATE Resultats SET etudiant_id=?, professeur_id=?, date_examen=?, nombre_notes=?, notes=? WHERE id=?";
                    PreparedStatement preparedStatement = database.getConnection().prepareStatement(query);
                    preparedStatement.setInt(1, etudiantId);
                    preparedStatement.setInt(2, professeurId);
                    preparedStatement.setDate(3, java.sql.Date.valueOf(dateExamen));
                    preparedStatement.setInt(4, nombreNotes);
                    preparedStatement.setString(5, notes);
                    preparedStatement.setInt(6, id);
                    preparedStatement.executeUpdate();

                    tableModel.setValueAt(etudiantId, selectedRow, 1);
                    tableModel.setValueAt(professeurId, selectedRow, 2);
                    tableModel.setValueAt(dateExamen, selectedRow, 3);
                    tableModel.setValueAt(nombreNotes, selectedRow, 4);
                    tableModel.setValueAt(notes, selectedRow, 5);

                    JOptionPane.showMessageDialog(this, "Résultat modifié avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erreur lors de la modification du résultat.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à modifier.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void deleteResult() {
            int selectedRow = resultsTable.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                try {
                    String query = "DELETE FROM Resultats WHERE id = ?";
                    PreparedStatement preparedStatement = database.getConnection().prepareStatement(query);
                    preparedStatement.setInt(1, id);
                    preparedStatement.executeUpdate();
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Résultat supprimé avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erreur lors de la suppression du résultat.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }