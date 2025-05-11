FROM maven:3.8.4-openjdk-17

COPY ./app /app

WORKDIR /app

# Comando para compilar o projeto
RUN mvn dependency:purge-local-repository && mvn clean package -X

CMD ["java", "-jar", "target/address-api-1.0-SNAPSHOT.jar"]