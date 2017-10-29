FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/zenith-living-history-api-0.1.0.jar app.jar
ARG SPRING_OPTS
ENV SPRING_OPTS $SPRING_OPTS
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /app.jar $SPRING_OPTS
