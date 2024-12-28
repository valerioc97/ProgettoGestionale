# Usa l'immagine ufficiale di OpenJDK 17 come base
FROM openjdk:17-jdk-slim

# Imposta la directory di lavoro nel container
WORKDIR /app

# Copia il JAR costruito nel container
COPY ProgettoGestionale-0.0.1-SNAPSHOT.jar /app/progettoGestionale.jar

# Espone la porta 8080
EXPOSE 8080

# Comando per eseguire l'applicazione Java
ENTRYPOINT ["java", "-jar", "/app/progettoGestionale.jar"]