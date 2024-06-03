# TP 2 – Évaluation des étudiants

## Contexte
Alain Dupont est un enseignant en informatique. Il saisit les notes des étudiants d’un groupe TP dans un tableau. Quand il a fini la saisie, il obtient la moyenne des étudiants et la médiane du groupe. Le programme affiche le nombre d’étudiants notés (taille du tableau), la moyenne ainsi que la médiane. Enfin, Alain Dupont veut stocker ce résultat en y ajoutant ses identifiants sous la forme : prénom, nom, email, date de l’examen, nombre d’étudiants, la moyenne et la médiane.

## Objectifs
- Créer un projet Maven
- Exécuter le code fourni
- Créer un dépôt Git local (ou distant) de votre projet
- Concevoir la structure de votre application et modifier le code
- Ajouter une méthode de tri de votre tableau puis calculer la médiane
- Assurer une qualité de développement élevée

## Structure du projet
- `calcultableau/`
  - `CalculTab.java`
  - `MainApp.java`
- `utilisateur/`
  - `UtilisateurTab.java`

## Étapes de réalisation

### Étape 1 : Créer un projet Maven
1. Initialisez un nouveau projet Maven.
2. Configurez le fichier `pom.xml` pour inclure les dépendances nécessaires (JUnit, AssertJ).

### Étape 2 : Exécuter le code fourni
1. Créez une classe `CalculTab` dans le package `calcultableau` avec le code fourni.
2. Exécutez la classe pour vous assurer que le code fonctionne.

### Étape 3 : Créer un dépôt Git
1. Initialisez un dépôt Git local dans le répertoire du projet.
2. Commitez les fichiers du projet et créez un dépôt distant (par exemple sur GitHub).

### Étape 4 : Concevoir la structure de l'application
1. Créez la classe `UtilisateurTab` dans le package `utilisateur`.
2. Séparez la classe principale avec `main()` de la classe `CalculTab`.
3. Modifiez `CalculTab` pour utiliser une `ArrayList` au lieu d'un tableau fixe.

### Étape 5 : Ajouter une méthode de tri et calculer la médiane
1. Implémentez une méthode de tri dans `CalculTab`.
2. Ajoutez une méthode pour calculer la médiane des notes.

### Étape 6 : Qualité de développement
1. Réfléchissez à la conception de votre application.
2. Utilisez un nommage clair et lisible.
3. Écrivez des tests unitaires pour assurer une couverture d’au moins 50%.
4. Utilisez des annotations avancées et AssertJ pour les tests.
5. Documentez votre code.

### Étape 7 : Travail Git
1. Faites des commits réguliers et vérifiez l’historique de votre dépôt Git.
2. Utilisez l’outil de comparaison de fichiers pour observer les différences entre deux versions.
3. Testez le « revert commit » pour revenir à une version précédente.

## Exemples de tests
- Méthodes de test avec le style `camel case` (lettresEnMajusculesEtEnMinusculesSansUnderscore).
- Décrire chaque étape de Arrange/Act/Assert ou Given/When/Then.

### Exemple de format d’un Email
```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestEmail {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Veuillez saisir votre mail: ");
            String email = sc.next("[\\w.-]+@[\\w.-]+\\.[a-z]{2,}");
            System.out.println(email + " : Email valide !");
        } catch (InputMismatchException e) {
            System.out.println("Email non valide");
        }
    }
}
