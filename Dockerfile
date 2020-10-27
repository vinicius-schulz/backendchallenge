FROM openjdk:8u212-jre-stretch
ADD target/backendchallenge-0.0.1-SNAPSHOT.jar backendchallenge-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backendchallenge-0.0.1-SNAPSHOT.jar"]