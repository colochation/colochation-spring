# 🐈 Colochation - back


![gif_cat](https://media.giphy.com/media/VCyJwT1DZEWyqU95oS/giphy.gif)

Colochation est une web application qui permet d'avoir une vue d'ensemble sur la vie de sa colocation.

Ce repository est le back utilisant [Spring Boot](https://spring.io/projects/spring-boot)
avec Java 19 et le gestionnaire de dépendances [Gradle](https://gradle.org/).

## Installation

```bash
./gradlew build
```

## Démarrage

Après avoir installé les dépendances avec `./gradlew build`, lancer le serveur :

```bash
./gradlew run
```


## Fonctionnalités de l’application

- Lister les tâches ménagères à effectuer
- Obtenir la liste des courses à faire
- Visualiser les prochains invités

## Routes
| Méthode | Chemin       | Statut Normal | Description                    |
|---------|--------------|---------------|--------------------------------|
| `GET`   | `/health`    | 200           | renvoie "OK"                   |
| `GET`   | `/chores`    | 200           | Récupère les tâches ménagères  |
| `GET`   | `/groceries` | 200           | Récupère la liste des courses  |
| `GET`   | `/guests`    | 200           | Récupère les prochains invités |

## Versioning

Aucun workflow n'est imposé. La seule branche protégée est `main` pour laquelle il doit y avoir une Pull Request avant
de merge.

## Auteurs 🪶

- Théo - [@ohmushi](https://github.com/ohmushi)
- [@nathan-dev-dot](https://github.com/nathan-dev-dot)
