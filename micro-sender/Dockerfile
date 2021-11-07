FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} micro-sender.jar
ENTRYPOINT ["java","-jar","/micro-sender.jar"]