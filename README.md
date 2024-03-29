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

```shell
# REDIS
docker build -t nighttheo/infra-as-code:redis -f redis/redis.Dockerfile ./redis
docker run --name iac-redis -p 6379:6379 -v ./redis/data:/data --network="iac" --rm -d nighttheo/infra-as-code:redis
```

```shell
# SPRING
docker build -t docker --push rg.fr-par.scw.cloud/colochation-registry/infra-as-code:colochation -f Dockerfile . 
docker run --name iac-colochation -p 8080:8080 --network="iac" --rm -d nighttheo/infra-as-code:colochation

docker build -t colochation-registry/infra-as-code:colochation -f Dockerfile . --push rg.fr-par.scw.cloud/colochation-registry/infra-as-code:colochation

docker build -t colochation-registry/infra-as-code:colochation -f  Dockerfile .
docker login rg.fr-par.scw.cloud/colochation-registry -u nologin --password-stdin <<< "$SCW_SECRET_KEY"
docker push rg.fr-par.scw.cloud/colochation-registry/infra-as-code:colochation
```


```shell
# MYSQL
docker run --name iac-mysql -e MYSQL_ROOT_PASSWORD=pwd -d mysql:8.2.0 --rm -d
```
