FROM openjdk:11

WORKDIR /app

ARG JAR_FILE=target/ecommerce-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} ecommerce.jar

ENTRYPOINT ["java","-jar","ecommerce.jar"]


