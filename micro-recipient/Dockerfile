FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} micro-recipient.jar
ENTRYPOINT ["java","-jar","/micro-recipient.jar"]