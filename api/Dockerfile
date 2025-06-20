# Etapa 1: build com Maven
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: imagem final com o jar
FROM eclipse-temurin:21

WORKDIR /app

# Copia o .jar gerado na etapa anterior
COPY --from=builder /app/target/api-0.0.1-SNAPSHOT.jar /app/sistema-ponto.jar

# Copia config opcional, se necessário
COPY src/main/resources/application-docker.properties /app/application-docker.properties

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "sistema-ponto.jar"]
