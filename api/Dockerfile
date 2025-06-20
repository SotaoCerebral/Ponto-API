FROM eclipse-temurin:21

RUN apt-get update
LABEL maintainer="matheusteixeira358@gmail.com"
WORKDIR /app

# Ajustado para o nome do seu .jar
COPY target/api-0.0.1-SNAPSHOT.jar /app/sistema-ponto.jar

# Copiando a configuração específica do perfil docker
COPY src/main/resources/application-docker.properties /app/application-docker.properties

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "sistema-ponto.jar"]
