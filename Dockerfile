FROM openjdk:21-buster
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT java ${JAVA_OPTS} -jar /app.jar