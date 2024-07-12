# Usar uma imagem base do Java 17
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo JAR da aplicação para o contêiner
COPY target/produto-crud-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que a aplicação vai usar
EXPOSE 8080

# Definir o comando de entrada para o contêiner
ENTRYPOINT ["java", "-jar", "app.jar"]
