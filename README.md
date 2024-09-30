# Projet de Gestion des Sites

## Technologies Utilisées

- **Java** : Langage principal pour développer l'application.
- **JDBC** : API utilisée pour interagir avec la base de données MySQL.
- **MySQL** : Système de gestion de base de données relationnelle pour le stockage des informations sur les sites.
- **IDE Java** : Environnements de développement tels qu'IntelliJ IDEA ou Eclipse utilisés pour coder et tester l'application.

## Principales Fonctionnalités

1. **Ajout de Sites** : Insertion de nouveaux sites dans la base de données avec un nom unique pour chaque site.
2. **Affichage des Sites** : Récupération et affichage des sites stockés dans la base de données avec leurs identifiants.
3. **Gestion des Connexions** : Utilisation de JDBC pour établir des connexions, exécuter des requêtes SQL, et manipuler les résultats.
4. **Gestion des Erreurs** : Traitement des exceptions et libération des ressources après les opérations sur la base de données pour garantir des performances optimales.

## Structure du Code

- **beans.Site** : Classe représentant un site avec deux attributs : un identifiant (ID) et un nom.
- **test.Test** : Classe gérant les opérations de base de données, comme l'insertion de nouveaux sites (méthode `save()`) et la récupération de tous les sites (méthode `load()`).
- **demo.Main** : Classe contenant la méthode `main`, qui permet de tester les fonctionnalités en ajoutant des sites et en affichant la liste complète des sites.
## Vidéo de Démonstration





https://github.com/user-attachments/assets/7119479b-1369-4406-b01e-1f233e58315d

