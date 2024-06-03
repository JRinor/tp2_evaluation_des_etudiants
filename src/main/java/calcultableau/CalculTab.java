package calcultableau;
import java.util.*;

public class CalculTab {
    private ArrayList<Integer> notes = new ArrayList<>();
    private int nombreEtudiants;
    private double moyenne;
    private double mediane;

    public double ajouterNote(int note) {
        notes.add(note);
        return note;
    }


    public double getMoyenne(ArrayList<Integer> notes) {
        int sum = 0;
        for (int i = 0; i < notes.size(); i++) {
            sum += notes.get(i);
        }
        return (double) sum / notes.size();
    }


    public int getNombreEtudiants() {
        return nombreEtudiants = notes.size();
    }

    public double getMediane() {
        Collections.sort(notes);
        if (notes.size() % 2 == 0) {
            mediane = (notes.get(notes.size() / 2) + notes.get(notes.size() / 2 - 1)) / 2;
        } else {
            mediane = notes.get(notes.size() / 2);
        }
        return mediane;
    }

    public String StringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre d'étudiants: ").append(getNombreEtudiants()).append("\n");
        sb.append("Moyenne: ").append(getMoyenne(notes)).append("\n");
        sb.append("Mediane: ").append(getMediane()).append("\n");
        return sb.toString();
    }
}