FROM openjdk:17
ARG JAR_FILE=target/*.jar
ADD target/spring-book-docker.jar spring-book-docker.jar
ENTRYPOINT ["java","-jar","/spring-book-docker.jar"]
