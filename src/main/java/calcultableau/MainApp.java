package calcultableau;

import utilisateur.UtilisateurTab;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        //int tab[] = new int[50];
        //int i;
        //int n = 0;
        //int Sum = 0;

        Scanner sc = new Scanner(System.in);

        String prenom = "";
        for (boolean prenomValid = false; !prenomValid; ) {
            System.out.println("Veuillez entrer votre prénom");
            prenom = sc.nextLine();
            if (prenom.matches("[a-zA-Z]+")) {
                prenomValid = true;
            } else {
                System.out.println("Invalide");
            }
        }

        String nom = "";
        for (boolean nomValid = false; !nomValid; ) {
            System.out.println("Veuillez entrer votre nom");
            nom = sc.nextLine();
            if (nom.matches("[a-zA-Z]+")) {
                nomValid = true;
            } else {
                System.out.println("Invalide");
            }
        }

        String email = "";
        for (boolean valid = false; !valid; ) {
            System.out.println("Veuillez entrer votre email");
            email = sc.nextLine();
            if (UtilisateurTab.validateEmail(email)) {
                valid = true;
            } else {
                System.out.println("Invalide");
            }
        }

        String dateExamen = "";
        for (boolean valid = false; !valid; ) {
            System.out.println("Veuillez entrer la date de l'examen (jj/mm/aaaa)");
            dateExamen = sc.nextLine();
            if (dateExamen.matches("\\d{2}/\\d{2}/\\d{4}")) {
                valid = true;
            } else {
                System.out.println("Invalide");
            }
        }

        UtilisateurTab utilisateur = new UtilisateurTab(prenom, nom, email, dateExamen);

        CalculTab calcul = new CalculTab();
        System.out.println("Veuillez entrer le nombre de notes :");
        while (!sc.hasNextInt()) {
            System.out.println("Ce n'est pas un nombre entier. Veuillez entrer un nombre entier.");
            sc.next();
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Veuillez entrer la note de l'étudiant " + (i + 1) + " :" );
            while (!sc.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre entier.");
                sc.next();
            }
            int note = sc.nextInt();
            if (note <0 || note > 20) {
                System.out.println("La note doit être comprise entre 0 et 20");
                i--;
                continue;
            }

            calcul.ajouterNote(note);
        }
        System.out.println("Informations sur l'utilisateur :");
        System.out.println(utilisateur.StringBuilder());
        System.out.println("Informations sur les notes :");
        System.out.println(calcul.StringBuilder());

        /*
        // LA TAILLE DU TABLEAU
        do {
            System.out.println("Veuillez entrer la taille du tableau");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
        } while (n > 50);
        // REMPLISSAGE DE TABLEAU
        System.out.println("****DEBUT PROGRAMME****");
        for (i = 0; i < n; i++) {
            System.out.println("Veuillez entrer un nombre");
            Scanner sc1 = new Scanner(System.in);
            tab[i] = sc1.nextInt();
        }
        // AFFICHAGE DE TABLEAU
        System.out.println("Les élements de tableau sont : ");
        for (i = 0; i < n; i++) {
            System.out.println(tab[i]);
        }
        // AFFICHAGE DE SOMME
        for (i = 0; i < n; i++) {
            Sum += tab[i];
        }
        System.out.println("La somme des éléments est égale à " + Sum);
        System.out.println("****FIN PROGRAMME****");
        */
    }
}
