# Usar uma imagem base do Java 21
FROM maven:3.9.8-amazoncorretto-21-al2023 AS build

COPY produto-crud/src /home/app/src
COPY produto-crud/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM amazoncorretto:21-al2023

# Copiar o arquivo JAR da aplicação para o contêiner
COPY --from=build /home/app/target/produto-crud-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]
