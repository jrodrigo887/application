FROM openjdk:17-alpine

# Ambiente
ENV DB_HOST=postgres
ENV DB_PORT=5432
ENV DB_NAME=postgres
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=admin

COPY /src/main/resources/application.properties /app/
COPY /src/main/resources/application-dev.properties /app/

WORKDIR /app

COPY target/application-0.0.1-SNAPSHOT.jar /app/application-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "application-0.0.1-SNAPSHOT.jar"]