FROM openjdk:17-slim AS builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM openjdk:17

COPY --from=builder build/libs/*.jar app.jar

COPY src/main/resources/application*.yml /app/resources/

RUN mkdir -p /usr/agent && \
    wget -O /usr/agent/dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

VOLUME /tmp

ENTRYPOINT ["java",
    "-javaagent:/usr/agent/dd-java-agent.jar",
    "-Ddd.profiling.enabled=true",
    "-Ddd.agent.host=localhost",
    "-Ddd.logs.injection=true",
    "-Ddd.service=discovery-api",
    "-Ddd.env=prod",
    "-Dspring.profiles.active=production",
    "-jar",
    "/app.jar"]
