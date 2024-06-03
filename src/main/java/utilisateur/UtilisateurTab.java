package utilisateur;

import java.util.regex.Pattern;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UtilisateurTab {

    private String nom;
    private String prenom;
    private String email;
    private String dateExamen;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    public static boolean validateEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public UtilisateurTab(String prenom, String nom, String email, String dateExamen) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateExamen = dateExamen;
    }

    public String StringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prénom: ").append(prenom).append("\n");
        sb.append("Nom: ").append(nom).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Date d'examen: ").append(dateExamen).append("\n");
        return sb.toString();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getDateExamen() {
        return dateExamen;
    }


}
