# Architecture Microservices avec Spring Boot & Docker

Ce projet met en œuvre une architecture microservices complète utilisant Spring Boot, Spring Cloud Gateway et MySQL, le tout conteneurisé avec Docker.

## 🏗 Architecture

Le projet est composé de 3 services principaux :

1.  **api-gateway (Port 8080)** : Point d'entrée unique. Redirige les requêtes vers les microservices appropriés.
2.  **ms-user (Port 8081)** : Gestion des utilisateurs (JPA/MySQL).
3.  **ms-location (Port 8082)** : Gestion des localisations GPS liées aux utilisateurs (JPA/MySQL).

Chaque microservice possède sa propre base de données MySQL isolée.

## 🚀 Comment lancer le projet

Pré-requis : Avoir **Docker** et **Docker Compose** installés.

1.  Cloner le dépôt :
    ```bash
    git clone [https://github.com/TON_USER/TP-Architecture-Microservices.git](https://github.com/TON_USER/TP-Architecture-Microservices.git)
    cd TP-Architecture-Microservices
    ```

2.  Lancer l'environnement complet (Build + Run) :
    ```bash
    docker-compose up -d --build
    ```
    *Note : Le premier lancement peut prendre quelques minutes le temps que Maven compile les projets et que Docker télécharge les images.*

3.  Vérifier que tout tourne :
    ```bash
    docker ps
    ```
    Vous devez voir 5 conteneurs : `api-gateway`, `ms-user`, `ms-location`, `user-db`, `location-db`.

## 🧪 Tester l'API

Toutes les requêtes passent par la Gateway sur le port **8080**.

### Via Postman ou Curl

**1. Créer un utilisateur :**
* **POST** `http://localhost:8080/ms-user/users`
* Body (JSON) :
    ```json
    {
      "nom": "Dupont",
      "prenom": "Jean",
      "email": "jean.dupont@email.com",
      "password": "1234password"
    }
    ```

**2. Ajouter une localisation pour cet utilisateur (ID 1) :**
* **POST** `http://localhost:8080/ms-location/locations`
* Body (JSON) :
    ```json
    {
        "latitude": 48.8566,
        "longitude": 2.3522,
        "userId": 1
    }
    ```

**3. Récupérer les infos :**
* Utilisateurs : `GET http://localhost:8080/ms-user/users`
* Localisations : `GET http://localhost:8080/ms-location/locations`

## 🛠 Technologies utilisées

* Java 17
* Spring Boot 3.3.0
* Spring Cloud Gateway
* Spring Data JPA
* MySQL 8
* Docker & Docker Compose