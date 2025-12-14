# --- Étape 1 : Construction (Build) ---
# On utilise une image avec Maven et Java 17
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# On copie d'abord le pom.xml pour télécharger les dépendances (mise en cache)
COPY pom.xml .
# On télécharge les dépendances (pour que ce soit plus rapide les prochaines fois)
RUN mvn dependency:go-offline -B

# On copie le code source
COPY src ./src

# On compile le projet et on crée le JAR (en sautant les tests pour aller plus vite)
RUN mvn clean package -DskipTests

# --- Étape 2 : Exécution (Run) ---
# On repart d'une image vierge et légère avec juste Java 17
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# On récupère le JAR construit à l'étape précédente
COPY --from=build /app/target/*.jar app.jar

# La commande pour lancer l'app
ENTRYPOINT ["java", "-jar", "app.jar"]