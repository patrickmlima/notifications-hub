FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY ./notifications/pom.xml .
COPY ./notifications/src ./src/
RUN mvn clean package -DskipTests

FROM openjdk:17-ea-17-slim-buster
VOLUME /tmp
ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8000
CMD ["--server.port=8000"]