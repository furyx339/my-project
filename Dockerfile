FROM eclipse-temurin:21

WORKDIR /app

COPY target/myproject-0.0.1-SNAPSHOT.jar /app/myproject.jar

ENTRYPOINT ["java", "-jar", "myproject.jar"]
