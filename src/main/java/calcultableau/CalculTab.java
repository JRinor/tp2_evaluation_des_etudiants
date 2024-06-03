package calcultableau;
import java.util.*;

public class CalculTab {
    private ArrayList<Integer> notes;
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
        return nombreEtudiants;
    }
    public double getMediane() {
        return mediane;
    }

    public String StringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombreEtudiants);
        sb.append(moyenne);
        sb.append(mediane);
        return sb.toString();
    }
}