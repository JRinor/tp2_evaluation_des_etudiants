# TP 2 – Évaluation des étudiants

Il s'agit d'une application Java qui gère les notes des étudiants et calcule des statistiques telles que la note moyenne et la note médiane. L'application valide également les entrées de l'utilisateur telles que l'e-mail, la date et les notes.

## Fonctionnalités

1. **Validation de l'utilisateur** : L'application valide les entrées de l'utilisateur telles que l'e-mail, la date et les notes. Elle s'assure que l'e-mail est au bon format, que la date est au format "jj/mm/aaaa", et que les notes sont comprises entre 0 et 20.

2. **Gestion des notes** : L'application permet à l'utilisateur de saisir les notes des étudiants et les stocke dans une ArrayList.

3. **Calcul des statistiques** : L'application calcule la note moyenne et la note médiane. Elle gère différents scénarios tels que lorsqu'aucune note n'est saisie, lorsque toutes les notes sont identiques, ou lorsqu'un nombre impair ou pair de notes est saisi.

4. **Gestion des erreurs** : L'application gère les erreurs de manière élégante. Par exemple, elle informe l'utilisateur lorsqu'une note est en dehors de la plage acceptable, ou lorsque des caractères non numériques sont saisis pour une note.

## Structure du Code

Le code est organisé en deux classes principales :

1. `UtilisateurTab` : Cette classe représente un utilisateur. Elle valide l'e-mail de l'utilisateur et formate les informations de l'utilisateur en une chaîne de caractères.

2. `CalculTab` : Cette classe gère les notes et calcule la note moyenne et la note médiane. Elle formate également les statistiques des notes en une chaîne de caractères.

La classe `MainApp` est le point d'entrée de l'application. Elle invite l'utilisateur à saisir ses informations et les notes des étudiants, puis affiche les informations de l'utilisateur et les statistiques des notes.

## Comment Exécuter

Il s'agit d'un projet Maven, vous pouvez donc le construire et l'exécuter à l'aide de l'outil de ligne de commande Maven. Voici les étapes :

1. Naviguez jusqu'au répertoire du projet dans votre terminal.

2. Construisez le projet en exécutant `mvn clean install`.

3. Exécutez l'application en exécutant `mvn exec:java -Dexec.mainClass="calcultableau.MainApp"`.

## Tests

Le projet comprend des tests unitaires pour les classes `UtilisateurTab` et `CalculTab`. Vous pouvez exécuter les tests en exécutant `mvn test` dans votre terminal.

