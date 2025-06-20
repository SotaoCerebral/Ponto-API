FROM eclipse-temurin:21

RUN apt-get update
LABEL maintainer="matheusteixeira358@gmail.com"

WORKDIR /app

# Corrigido o nome do JAR aqui
COPY target/api-0.0.1-SNAPSHOT.jar /app/sistema-ponto.jar
COPY src/main/resources/application-docker.properties /app/application-docker.properties

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "sistema-ponto.jar"]
