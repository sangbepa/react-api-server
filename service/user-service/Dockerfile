FROM eclipse-temurin:21-jre-jammy
VOLUME /tmp
RUN apt-get update && apt-get install -y curl
COPY ./build/libs/*.jar user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar"]
