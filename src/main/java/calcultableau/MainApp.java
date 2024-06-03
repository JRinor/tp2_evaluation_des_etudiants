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

        System.out.println("Veuillez entrer votre prénom");
        String prenom = sc.nextLine();

        System.out.println("Veuillez entrer votre nom");
        String nom = sc.nextLine();

        String email;
        for (boolean valid = false; !valid; ) {
            System.out.println("Veuillez entrer votre email");
            email = sc.nextLine();
            if (UtilisateurTab.validateEmail(email)) {
                valid = true;
            } else {
                System.out.println("Email invalide");
            }
        }

        System.out.println("Veuillez entrer la date de l'examen");
        String dateExamen = sc.nextLine();

        UtilisateurTab utilisateur = new UtilisateurTab(prenom, nom, email, dateExamen);

        CalculTab calcul = new CalculTab();
        System.out.println("Veuillez entrer le nombre de notes :");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Veuillez entrer une note :");
            int note = sc.nextInt();
            calcul.ajouterNote(note);
        }


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
