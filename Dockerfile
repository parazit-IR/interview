FROM openjdk:8-jre-alpine
VOLUME /tmp
EXPOSE 9091
ADD target/*.jar app.jar
ENTRYPOINT exec java -jar /app.jar interview



