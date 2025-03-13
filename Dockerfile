
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app


COPY pom.xml .
COPY src ./src


RUN mvn clean package -DskipTests


FROM eclipse-temurin:21
WORKDIR /app


COPY --from=build /app/target/myproject-0.0.1-SNAPSHOT.jar myproject.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "myproject.jar"]