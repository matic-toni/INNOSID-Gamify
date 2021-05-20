FROM openjdk:11.0.5-jre-slim
ADD target/spring-boot-docker.war spring-boot-docker.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/spring-boot-docker.war"]