FROM openjdk:10

ENV APP_DIR /app
WORKDIR "${APP_DIR}"

COPY ["build/*.jar", "/app/ezypay-0.0.1.SNAPSHOT.jar"]

EXPOSE 8080

CMD ["java", "-jar", "-Dserver.port=8080" ,"/app/ezypay-0.0.1.SNAPSHOT.jar"]
