# TP 2 – Évaluation des étudiants

## Étape par Étape pour Réaliser le Travail

### Étape 1: Concevoir la structure de l'application et modifier le code
1. **Créez les packages `calcultableau` et `utilisateur` si ce n'est pas déjà fait.**
2. **Ajoutez une classe `UtilisateurTab` dans le package `utilisateur`.**

### Étape 2: Créer la classe `UtilisateurTab`
1. **Définissez les attributs nécessaires (`prenom`, `nom`, `email`, `dateExamen`).**
2. **Ajoutez un constructeur pour initialiser ces attributs.**
3. **Ajoutez une validation pour l'email avec une regex.**

### Étape 3: Séparer la classe principale avec `main()` de la classe `CalculTab`
1. **Créez une classe `MainApp` dans le package `calcultableau`.**
2. **Déplacez la méthode `main` de `CalculTab` à `MainApp`.**

### Étape 4: Modifier `CalculTab`
1. **Remplacez le tableau fixe `tab[]` par une `ArrayList` (ou une autre collection).**
2. **Ajoutez des méthodes pour ajouter des notes, calculer la somme, la moyenne, et la médiane.**
3. **Utilisez `StringBuilder` pour une méthode `toString`.**

### Étape 5: Compléter la classe principale `MainApp`
1. **Ajoutez du code pour saisir les informations utilisateur.**
2. **Ajoutez du code pour saisir les notes des étudiants.**
3. **Appelez les méthodes de `CalculTab` pour calculer les statistiques.**
4. **Affichez les résultats (nombre d'étudiants, moyenne, médiane).**
5. **Affichez les informations utilisateur.**

### Étape 6: Ajouter une méthode de tri et calculer la médiane
1. **Ajoutez une méthode de tri des notes dans `CalculTab`.**
2. **Calculez la médiane après avoir trié les notes.**

### Étape 7: Qualité de développement
1. **Réfléchissez à la conception de votre application et écrivez un scénario.**
2. **Utilisez un nommage clair et lisible pour les variables et méthodes.**
3. **Écrivez des tests unitaires pour s'assurer d'une couverture d'au moins 50%.**
4. **Utilisez des annotations avancées et AssertJ pour les tests.**
5. **Documentez votre code avec des commentaires appropriés.**

### Étape 8: Travail Git
1. **Faites des commits réguliers de votre projet.**
2. **Regardez l'historique de votre dépôt Git.**
3. **Utilisez l'outil de comparaison pour voir les différences entre deux versions.**
4. **Testez `revert commit` pour revenir à une version précédente.**

### Étape 9: Approche TDD
1. **Essayez de développer votre code en suivant l'approche TDD (Test-Driven Development).**
2. **Écrivez d'abord des tests pour les fonctionnalités que vous allez développer.**
3. **Implémentez les fonctionnalités pour que les tests passent.**

## Tests
1. **Utilisez le camel case pour nommer vos tests (e.g., `addTwoPositiveIntegersReturnsTheirSum`).**
2. **Décrivez chaque étape des tests en utilisant Arrange/Act/Assert ou Given/When/Then.**
3. **Utilisez l'annotation `@DisplayName` pour mieux nommer vos tests.**
