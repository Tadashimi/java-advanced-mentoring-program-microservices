FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} micro-collector.jar
ENTRYPOINT ["java","-jar","/micro-collector.jar"]