# Utilisation de l'image OpenJDK 11 officielle en tant qu'image de base
FROM openjdk:11

# Copie du fichier JAR depuis le système de fichiers local vers l'image Docker
COPY target/AmineKadem-0.0.1-SNAPSHOT.jar /app.jar

# Commande d'exécution du fichier JAR lorsque le conteneur Docker est démarré
CMD ["java", "-jar", "/app.jar"]

