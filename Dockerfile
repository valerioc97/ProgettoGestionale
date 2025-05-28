# Usa immagine base OpenJDK 17 slim
FROM openjdk:17-jdk-slim

# Crea e imposta la directory di lavoro
WORKDIR /app

# Copia il jar dentro il container
COPY target/ProgettoGestionale-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta (Spring Boot di solito gira su 8080)
EXPOSE 8080

# Comando di avvio
ENTRYPOINT ["java", "-jar", "app.jar"]
